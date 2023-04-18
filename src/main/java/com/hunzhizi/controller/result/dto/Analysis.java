package com.hunzhizi.controller.result.dto;

import com.hunzhizi.domain.Color;
import com.hunzhizi.domain.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-02-22 12:10
 * program: graduation-design
 * description: 分析调用返回的结果
 */
public class Analysis {
    private Integer photoId;
    private Integer filmId;
    private String photoFormat;
    private String photoAddress;
    private String photoLabelAddress;
    private List<String> rgbs;

    public Analysis() {
    }

    /**
     * 主要用于精准分析模式的构造器
     * @param photo
     * @param rgbs
     */
    public Analysis(List<String> rgbs) {
        this.rgbs = rgbs;
    }

    /**
     * 主要适用于查询结果的返回,用此构造器
     * @param photo
     * @param color
     */
    public Analysis(Photo photo, Color color) {
        this.photoId = photo.getPhotoId();
        this.filmId = photo.getFilmId();
        this.photoFormat = photo.getPhotoFormat();
        this.photoAddress = photo.getPhotoAddress();
        this.photoLabelAddress = photo.getPhotoLabelAddress();
        this.rgbs = color.convert2String();
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getPhotoFormat() {
        return photoFormat;
    }

    public void setPhotoFormat(String photoFormat) {
        this.photoFormat = photoFormat;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    public String getPhotoLabelAddress() {
        return photoLabelAddress;
    }

    public void setPhotoLabelAddress(String photoLabelAddress) {
        this.photoLabelAddress = photoLabelAddress;
    }

    public List<String> getRgbs() {
        return rgbs;
    }

    public void setRgbs(List<String> rgbs) {
        this.rgbs = rgbs;
    }
}
