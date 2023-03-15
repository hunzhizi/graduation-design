package com.hunzhizi.service;

import com.hunzhizi.domain.Label;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 19:26
 * program: graduation-design
 * description:
 */
public interface LabelService {
    Boolean createLabel(Label label);

    /**
     *
     * @param fields 序列化规则为 两个数字之间用 # 间隔
     * @return 返回photoId
     */
    List<Integer> getLabelByField(String fields);

    boolean labelImg(String imgName,int photoId);

}
