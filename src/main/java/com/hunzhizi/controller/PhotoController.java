package com.hunzhizi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.result.Result;
import com.hunzhizi.controller.result.dto.Analysis;
import com.hunzhizi.controller.result.dto.MyPage;
import com.hunzhizi.domain.Color;
import com.hunzhizi.domain.Film;
import com.hunzhizi.domain.Photo;
import com.hunzhizi.service.ColorService;
import com.hunzhizi.service.FilmService;
import com.hunzhizi.service.LabelService;
import com.hunzhizi.service.PhotoService;
import com.hunzhizi.tool.PicUtil;
import com.hunzhizi.tool.PythonCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

/**
 * @author 魂之子
 * @since 2023-03-14 21:02
 * program: graduation-design
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private LabelService labelService;

    //测试服务器部署方便测试
/*    @PostMapping("/uploadImg")
    @Transactional
    public Result uploadImg(@RequestParam("imgFile") MultipartFile imgFile,
                            @RequestParam("filmName") String filmName,
                            @RequestParam("filmDesc") String filmDesc,
                            @RequestParam("filmType") Integer typeId) {
        return new Result(1, new Analysis(photoService.getPhotoByPhotoId(1), colorService.getColorByPhotoId(1)));
    }*/

//    @PostMapping("/precise")
//    public Result preciseMode(@RequestParam("imgFile") MultipartFile imgFile,
//                              @RequestParam("themeNum") Integer themeNum) {
//        String[] arr = {
//                "#d5c99c",
//                "#4a3f2e",
//                "#9e8a5f",
//                "#12100d",
//                "#79613b",
//                "#2c2219",
//                "#949879",
//                "#3d4225",
//                "#edefe7",
//                "#c1c1b1",
//                "#6d6d47",
//                "#dde77c",
//                "#050604",
//                "#3f3633",
//                "#968882",
//                "#bdb4af",
//                "#1b1c1a",
//                "#6b5853",
//                "#c2cdc9",
//                "#4d5d5c",
//                "#11181b",
//                "#364444",
//                "#242f2f",
//                "#7d918d"
//        };
//        ArrayList<String> strings = new ArrayList<>(Arrays.asList(arr).subList(0, themeNum));
//        return new Result(1, new Analysis(strings));
//    }

    @PostMapping("/uploadImg")
    @Transactional
    public Result uploadImg(@RequestParam("imgFile") MultipartFile imgFile,
                            @RequestParam("filmName") String filmName,
                            @RequestParam("filmDesc") String filmDesc,
                            @RequestParam("filmType") Integer typeId) {
        String orgName = imgFile.getOriginalFilename();
        assert orgName != null;
        String suffix = orgName.substring(orgName.lastIndexOf('.') + 1);
        UUID key = UUID.randomUUID();
        String newPicName = key.toString() + "." + suffix;
        String newLabelName = key.toString() + "label" + "." + suffix;
        try {
            imgFile.transferTo(new File(PythonCall.UPLODA_DIR + newPicName));
            log.info(filmName + "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Photo photo = new Photo();
        photo.setPhotoFormat(suffix);
        //todo 文件上传文件服务器逻辑

        photo.setPhotoAddress(newPicName);
        photo.setPhotoLabelAddress(newLabelName);


        if (filmName != null && !filmName.equals("")) {
            Film film = filmService.getFilmByName(filmName);
            if (film != null) {
                photo.setFilmId(film.getFilmId());
            } else {
                film = new Film();
                film.setFilmName(filmName);
                film.setDesc(filmDesc);
                if(typeId!=null) film.setType(typeId);
                Boolean isCreateFilm = filmService.createFilm(film);
                photo.setFilmId(film.getFilmId());
            }
        }
        boolean isUpload = photoService.createPhoto(photo);
        Integer photoId = photo.getPhotoId();
        Color color = new Color();
        color.setPhotoId(photoId);
        //todo 用两个线程并行跑，提高效率
        Thread analyzeColor = new Thread(() -> colorService.analyzeColor(newPicName, color), "分析主色调");
        Thread labelImg = new Thread(() -> labelService.labelImg(newPicName, photoId), "图片打标");
        analyzeColor.start();
        labelImg.start();
        PicUtil.uploadByLocalFilePath(PythonCall.UPLODA_DIR + newPicName, newPicName);
        try {
            analyzeColor.join();
            labelImg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo 这个线程出错不会全部回滚，需要手动事务控制，存在线程安全问题。
        PicUtil.uploadByLocalFilePath(PythonCall.INFER_DIR + newPicName, newLabelName);
        log.info("photoid=" + photoId);
        Analysis analysis = new Analysis(photo, color);
        return isUpload ? new Result(1, analysis) : new Result(2, "fail");
    }

    @PostMapping("/precise")
    public Result preciseMode(@RequestParam("imgFile") MultipartFile imgFile,
                              @RequestParam("themeNum") Integer themeNum){
        String orgName = imgFile.getOriginalFilename();
        assert orgName != null;
        String suffix = orgName.substring(orgName.lastIndexOf('.') + 1);
        UUID key = UUID.randomUUID();
        String newPicName = key.toString() + "." + suffix;
        File file = new File(PythonCall.UPLODA_DIR + newPicName);
        try {
            imgFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> strings = colorService.analyzeColorPrecise(newPicName,themeNum);

        file.delete();
        return new Result(1,new Analysis(strings));

    }

    @PostMapping("/search/{pageNum}/{pageSize}")
    public Result searchPhoto(@RequestParam("classes") String classes,
                              @RequestParam("rgb") String rgb,
                              @RequestParam("filmType") Integer filmType,
                              @RequestParam("filmName") String filmName,
                              @PathVariable Integer pageNum,
                              @PathVariable Integer pageSize) {
        List<Integer> conditionLabel = null;
        List<Integer> conditionColor = null;
        List<Integer> conditionFilmId = null;
        List<Integer> conditionFilmType = null;

//        PageHelper.startPage(pageNum,pageSize);
        //set 取交集
        Set<Integer> set = new HashSet<>();
        //条件1：通过标签筛选
        if (classes != null && !classes.trim().equals("")) {
            conditionLabel = labelService.getLabelByField(classes);
            set = unique(set, conditionLabel);
        }
        if (rgb != null && !rgb.trim().equals("")) {
            //传入规则不同rgb之间使用!间隔
            conditionColor = colorService.pickColor(rgb.split("!"));
            set = unique(set, conditionColor);
        }
        if (filmName != null && !filmName.trim().equals("")) {
            Film film = filmService.getFilmByName(filmName);
            if (film == null) {
                return new Result(0, "数据库中目前没有该电影的信息");
            }
            conditionFilmId = photoService.getPhotoIdByFilmId(film.getFilmId());
            set = unique(set, conditionFilmId);
        }
        if (filmType != null) {
            conditionFilmType = new ArrayList<>();
            List<Integer> filmIdByType = filmService.getFilmIdByType(filmType);
            for (Integer integer : filmIdByType) {
                List<Integer> photoId = photoService.getPhotoIdByFilmId(integer);
                conditionFilmType.addAll(photoId);
            }
            set = unique(set, conditionFilmType);
        }

        ArrayList<Analysis> analyses = new ArrayList<>();
        for (Integer integer : set) {
            log.info("answer" + integer);
        }
        //上述做完去重
        for (Integer integer : set) {
            Photo photo = photoService.getPhotoByPhotoId(integer);
            log.info(photo == null ? "null" : "not null");
            Color color = colorService.getColorByPhotoId(integer);
            analyses.add(new Analysis(photo, color));
        }
        //todo 服务器方便测试本来应该是下面这行代码
//        if(analyses.size()==0) return new Result(0,"数据库中没有查询到符合该类别的图片");
        if (analyses.size() == 0) {
            List<Photo> allPhotos = photoService.getAllPhotos();
            ArrayList<Analysis> res = new ArrayList<>();
            for (Photo allPhoto : allPhotos) {
                Color color = colorService.getColorByPhotoId(allPhoto.getPhotoId());
                res.add(new Analysis(allPhoto, color));
            }
//            PageInfo<Analysis> data = new PageInfo<>(res);
//            data.setPageNum(pageNum);
//            data.setPageSize(pageSize);
//            data.setSize(data.getList().size());
//            data.setTotal(photoService.getNumOfPhotos());
//            if(res.size() - pageNum * pageSize < 0 ){
//                data.setSize(res.size() - (pageNum-1) * pageSize);
//                log.info("size"+ (res.size() - (pageNum-1) * pageSize));
//            }
            log.info("res" + res);
            MyPage listMyPage = new MyPage(res, pageNum, pageSize);
            return new Result(1, listMyPage);
            //---------------测试代码结束------------
        }

        return new Result(1, new MyPage(analyses,pageNum,pageSize));
    }


    public static Set<Integer> unique(Set<Integer> set, List<Integer> list) {
        if (set.size() == 0) {
            set.addAll(list);
            return set;
        }
        HashSet<Integer> res = new HashSet<>();
        for (Integer integer : list) {
            if (set.contains(integer)) {
                res.add(integer);
            }
        }
        return res;
    }
}
