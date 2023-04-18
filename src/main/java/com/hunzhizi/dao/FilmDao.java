package com.hunzhizi.dao;

import com.hunzhizi.domain.Film;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-11 19:51
 * program: graduation-design
 * description:
 */
@Mapper
public interface FilmDao {

    Boolean createFilm(Film film);

    @Select("select * from film")
    List<Film> getAllFilms();

    @Select("select * from film " +
            "where film_id = #{filmId}")
    Film getFilmsById(Integer filmId);

    @Select("select film_id from film " +
            "where type = #{type}")
    List<Integer> getFilmsByType(Integer type);

    @Select("select * from film " +
            "where film_name = #{filmName}")
    Film getFilmByName(String filmName);

}
