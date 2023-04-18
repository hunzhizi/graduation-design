package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.Photo;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 20:42
 * program: graduation-design
 * description:
 */
public interface PhotoService {

    boolean createPhoto(Photo photo);

    PageInfo<Photo> getPhotoByPhotoIds(List<Integer> ids, int pageNum, int pageSize);

    Photo getPhotoByPhotoId(int photoId);

    List<Integer> getPhotoIdByFilmId(int filmId);

    List<Photo> getAllPhotos();

    Integer getNumOfPhotos();
}
