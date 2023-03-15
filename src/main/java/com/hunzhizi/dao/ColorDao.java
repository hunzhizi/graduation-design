package com.hunzhizi.dao;

import com.hunzhizi.domain.Color;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-11 22:04
 * program: graduation-design
 * description:
 */
@Mapper
public interface ColorDao {
    @Select("select * from color where color_id = #{colorId}")
    Color selectByColorId(Integer colorId);

    @Select("select * from color where photo_id = #{photoId}")
    Color selectByPhotoId(Integer photoId);

    @Insert("insert into color(photo_id,theme_one_r,theme_one_g,theme_one_b,theme_two_r,theme_two_g,theme_two_b,theme_three_r,theme_three_g,theme_three_b,theme_four_r,theme_four_g,theme_four_b,theme_five_r,theme_five_g,theme_five_b,theme_six_r,theme_six_g,theme_six_b) " +
            "values(#{photoId},#{themeOneR},#{themeOneG},#{themeOneB},#{themeTwoR},#{themeTwoG},#{themeTwoB},#{themeThreeR},#{themeThreeG},#{themeThreeB},#{themeFourR},#{themeFourG},#{themeFourB},#{themeFiveR},#{themeFiveG},#{themeFiveB},#{themeSixR},#{themeSixG},#{themeSixB})")
    Boolean createColor(Color color);

    /**
     * 根据rgb的值选择color_id
     * @param r
     * @param g
     * @param b
     * @return
     */
    @Select("select color_id from color where " +
            "(theme_one_r > #{r} - 15 and theme_one_r < #{r} + 15 and theme_one_g > #{g} - 15 and theme_one_g < #{g} + 15 and theme_one_b > #{b} - 15 and theme_one_b < #{b} + 15) or " +
            "(theme_two_r > #{r} - 15 and theme_two_r < #{r} + 15 and theme_two_g > #{g} - 15 and theme_two_g < #{g} + 15 and theme_two_b > #{b} - 15 and theme_two_b < #{b} + 15) or" +
            "(theme_three_r > #{r} - 15 and theme_three_r < #{r} + 15 and theme_three_g > #{g} - 15 and theme_three_g < #{g} + 15 and theme_three_b > #{b} - 15 and theme_three_b < #{b} + 15) or" +
            "(theme_four_r > #{r} - 15 and theme_four_r < #{r} + 15 and theme_four_g > #{g} - 15 and theme_four_g < #{g} + 15 and theme_four_b > #{b} - 15 and theme_four_b < #{b} + 15) or" +
            "(theme_five_r > #{r} - 15 and theme_five_r < #{r} + 15 and theme_five_g > #{g} - 15 and theme_five_g < #{g} + 15 and theme_five_b > #{b} - 15 and theme_five_b < #{b} + 15) or" +
            "(theme_six_r > #{r} - 15 and theme_six_r < #{r} + 15 and theme_six_g > #{g} - 15 and theme_six_g < #{g} + 15 and theme_six_b > #{b} - 15 and theme_six_b < #{b} + 15) "
    )
    List<Integer> selectByRGB1(Integer r, Integer g, Integer b);

    List<Color> selectByIds(@Param("alsit") List<Integer> list);

}
