package com.hunzhizi.dao;

import com.hunzhizi.domain.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-12 23:33
 * program: graduation-design
 * description:
 */
@Mapper
public interface PhotoDao {
    @Select("select * from photo where photo_id = #{photoId}")
    Photo selectByPhotoId(Integer photoId);

    List<Photo> selectByPhotoIds(List<Integer> ids);

    @Insert("insert into photo(film_id, photo_format, photo_address, photo_label_address) " +
            "values(#{filmId}, #{photoFormat}, #{photoAddress}, #{photoLabelAddress})")
    @Options(useGeneratedKeys = true,keyColumn = "photo_id",keyProperty = "photoId")
    Boolean createPhoto(Photo photo);

    @Select("select photo_id from photo where film_id = #{filmId}")
    List<Integer> getPhotoIdByFilmId(Integer filmId);


    @Select("select * from photo")
    List<Photo> getAllPhoto();

    @Select("select count(*) from photo")
    Integer getNumOfPhotos();
}
