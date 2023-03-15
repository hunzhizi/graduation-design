package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @since 2023-03-12 23:31
 * program: graduation-design
 * description:
 */
public class Photo {
    private Integer photoId;
    private Integer filmId;
    private String photoFormat;
    private String photoAddress;
    private String photoLabelAddress;

    public Photo() {
    }

    public Photo(Integer photoId, Integer filmId, String photoFormat, String photoAddress, String photoLabelAddress) {
        this.photoId = photoId;
        this.filmId = filmId;
        this.photoFormat = photoFormat;
        this.photoAddress = photoAddress;
        this.photoLabelAddress = photoLabelAddress;
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

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", filmId=" + filmId +
                ", photoFormat='" + photoFormat + '\'' +
                ", photoAddress='" + photoAddress + '\'' +
                ", photoLabelAddress='" + photoLabelAddress + '\'' +
                '}';
    }
}
