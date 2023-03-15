package com.hunzhizi.controller;

import com.hunzhizi.controller.result.Result;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @PostMapping("/uploadImg")
    public Result uploadImg(@RequestParam("imgFile") MultipartFile imgFile,
                            @RequestParam("filmName") String filmName){
        String orgName = imgFile.getOriginalFilename();
        assert orgName != null;
        String suffix = orgName.substring(orgName.lastIndexOf('.')+1);
        UUID key = UUID.randomUUID();
        String newPicName = key.toString() +"." +  suffix;
        String newLabelName = key.toString() + "label" +"." + suffix;
        try {
            imgFile.transferTo(new File(PythonCall.UPLODA_DIR+newPicName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Photo photo = new Photo();
        photo.setPhotoFormat(suffix);
        //todo 文件上传文件服务器逻辑

        photo.setPhotoAddress(newPicName);
        photo.setPhotoLabelAddress(newLabelName);


        if(filmName!=null && !filmName.equals("")){
            Film film = filmService.getFilmByName(filmName);
            if(film!=null){
                photo.setFilmId(film.getFilmId());
            }
        }
        boolean isUpload = photoService.createPhoto(photo);
        Integer photoId = photo.getPhotoId();
        //todo 用两个线程并行跑，提高效率
        Thread analyzeColor = new Thread(() -> colorService.analyzeColor(newPicName, photoId),"分析主色调");
        Thread labelImg = new Thread(() -> labelService.labelImg(newPicName, photoId),"图片打标");
        analyzeColor.start();
        labelImg.start();
        PicUtil.uploadByLocalFilePath(PythonCall.UPLODA_DIR + newPicName,newPicName);
        try {
            analyzeColor.join();
            analyzeColor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PicUtil.uploadByLocalFilePath(PythonCall.INFER_DIR + newPicName,newLabelName);
        return isUpload? new Result(1,"success"): new Result(2,"fail");
    }
}
