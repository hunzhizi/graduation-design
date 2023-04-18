package com.hunzhizi.service.impl;

import com.hunzhizi.controller.result.dto.Analysis;
import com.hunzhizi.dao.ColorDao;
import com.hunzhizi.domain.Color;
import com.hunzhizi.service.ColorService;
import com.hunzhizi.tool.ConvertRGB;
import com.hunzhizi.tool.PythonCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 12:56
 * program: graduation-design
 * description:
 */
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorDao colorDao;

    @Override
    public List<Integer> pickColor(String[] theme) {
        if (theme.length == 1) {
            int[] ints = ConvertRGB.hex2int(theme[0]);
            return colorDao.selectByRGB1(ints[0], ints[1], ints[2]);
        }
        int[] ints = ConvertRGB.hex2int(theme[0]);
        List<Integer> list = colorDao.selectByRGB1(ints[0], ints[1], ints[2]);
        HashSet<Integer> set = new HashSet<>(list);
        for (String s : theme) {
            HashSet<Integer> res = new HashSet<>();
            ints = ConvertRGB.hex2int(s);
            List<Integer> list2 = colorDao.selectByRGB1(ints[0], ints[1], ints[2]);
            for (Integer integer : list2) {
                if (set.contains(integer)) {
                    res.add(integer);
                }
            }
            set = res;
        }

        return new ArrayList<>(set);
    }

    @Override
    public Color getColorByPhotoId(Integer photoId) {
        Color color = colorDao.selectByPhotoId(photoId);
        return color;
    }

    @Override
    public Boolean createColor(Color color) {
        return colorDao.createColor(color);
    }

    /**
     * 传入一个设置过colorid的过来
     * @param imgName
     * @param color
     * @return
     */
    @Override
    public boolean analyzeColor(String imgName, Color color) {
        List<String> strings = PythonCall.analyzeColor(PythonCall.UPLODA_DIR + imgName);
//        Color color = new Color();
//        color.setPhotoId(photoId);
        color.setThemeOneR(ConvertRGB.parsePyReturnValue(strings.get(0))[0]);
        color.setThemeOneG(ConvertRGB.parsePyReturnValue(strings.get(0))[1]);
        color.setThemeOneB(ConvertRGB.parsePyReturnValue(strings.get(0))[2]);
        color.setThemeTwoR(ConvertRGB.parsePyReturnValue(strings.get(1))[0]);
        color.setThemeTwoG(ConvertRGB.parsePyReturnValue(strings.get(1))[1]);
        color.setThemeTwoB(ConvertRGB.parsePyReturnValue(strings.get(1))[2]);
        color.setThemeThreeR(ConvertRGB.parsePyReturnValue(strings.get(2))[0]);
        color.setThemeThreeG(ConvertRGB.parsePyReturnValue(strings.get(2))[1]);
        color.setThemeThreeB(ConvertRGB.parsePyReturnValue(strings.get(2))[2]);
        color.setThemeFourR(ConvertRGB.parsePyReturnValue(strings.get(3))[0]);
        color.setThemeFourG(ConvertRGB.parsePyReturnValue(strings.get(3))[1]);
        color.setThemeFourB(ConvertRGB.parsePyReturnValue(strings.get(3))[2]);
        color.setThemeFiveR(ConvertRGB.parsePyReturnValue(strings.get(4))[0]);
        color.setThemeFiveG(ConvertRGB.parsePyReturnValue(strings.get(4))[1]);
        color.setThemeFiveB(ConvertRGB.parsePyReturnValue(strings.get(4))[2]);
        color.setThemeSixR(ConvertRGB.parsePyReturnValue(strings.get(5))[0]);
        color.setThemeSixG(ConvertRGB.parsePyReturnValue(strings.get(5))[1]);
        color.setThemeSixB(ConvertRGB.parsePyReturnValue(strings.get(5))[2]);

        return createColor(color);

    }

    @Override
    public List<String> analyzeColorPrecise(String imgName,int themeNum) {
        List<String> strings = PythonCall.analyzeColor(PythonCall.UPLODA_DIR + imgName,themeNum);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            int[] ints = ConvertRGB.parsePyReturnValue(strings.get(i));
            res.add(ConvertRGB.int2Hex(ints[0],ints[1],ints[2]));
        }
        return res;

    }


}
