package com.hunzhizi.service;

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

    List<Photo> getPhotoByPhotoIds(List<Integer> ids);

    Photo getPhotoByPhotoId(int photoId);
}
