package com.hunzhizi.service;

import com.hunzhizi.domain.Color;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 12:01
 * program: graduation-design
 * description:
 */
public interface ColorService {
    /**
     * 传入一个theme的String类型数组，返回对应的photoId
     * @param theme
     * @return
     */
    List<Integer> pickColor(String[] theme);

    Color getColorByPhotoId(Integer photoId);

    Boolean createColor(Color color);

    boolean analyzeColor(String imgName,int photoId);
}
