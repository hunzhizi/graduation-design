package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.PhotoDao;
import com.hunzhizi.domain.Photo;
import com.hunzhizi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 20:49
 * program: graduation-design
 * description:
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDao photoDao;
    @Override
    public boolean createPhoto(Photo photo) {
        return photoDao.createPhoto(photo);
    }

    @Override
    public PageInfo<Photo> getPhotoByPhotoIds(List<Integer> ids, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Photo> photos = photoDao.selectByPhotoIds(ids);
        return new PageInfo<>(photos);
    }

    @Override
    public Photo getPhotoByPhotoId(int photoId) {
        return photoDao.selectByPhotoId(photoId);
    }

    @Override
    public List<Integer> getPhotoIdByFilmId(int filmId) {
        return photoDao.getPhotoIdByFilmId(filmId);
    }

    @Override
    public List<Photo> getAllPhotos() {
        return photoDao.getAllPhoto();
    }

    @Override
    public Integer getNumOfPhotos() {
        return photoDao.getNumOfPhotos();
    }
}
