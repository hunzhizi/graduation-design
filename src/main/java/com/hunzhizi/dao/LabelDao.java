package com.hunzhizi.dao;

import com.hunzhizi.domain.Label;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-12 20:18
 * program: graduation-design
 * description:
 */
@Mapper
public interface LabelDao {
    @Select("select * from label where photo_id = #{photoId}")
    Label selectByPhotoId(Integer photoId);

    //返回photo_id 根据字段进行查找,并返回photo_id
    List<Integer> selectByField(@Param("alsit") List<String> list);

    Boolean createLabel(Label label);
}
