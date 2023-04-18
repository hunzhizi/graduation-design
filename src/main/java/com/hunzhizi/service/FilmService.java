package com.hunzhizi.service;

import com.hunzhizi.domain.Film;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 19:04
 * program: graduation-design
 * description:
 */
public interface FilmService {
    Boolean createFilm(Film film);

    Film getFilmByFilmId(Integer filmId);

    Film getFilmByName(String filmName);

    List<Integer> getFilmIdByType(Integer typeId);
}
