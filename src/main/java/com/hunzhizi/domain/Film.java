package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @since 2023-03-11 19:47
 * program: graduation-design
 * description:
 */
public class Film {
    private Integer filmId;
    private String filmName;
    private Integer type;
    private String desc;

    public Film() {
    }

    public Film(Integer filmId, String filmName, Integer type, String desc) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.type = type;
        this.desc = desc;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
