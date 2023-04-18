package com.hunzhizi.service.impl;

import com.hunzhizi.dao.FilmDao;
import com.hunzhizi.domain.Film;
import com.hunzhizi.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 19:24
 * program: graduation-design
 * description:
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDao filmDao;
    @Override
    public Boolean createFilm(Film film) {
        return filmDao.createFilm(film);
    }

    @Override
    public Film getFilmByFilmId(Integer filmId) {
        return filmDao.getFilmsById(filmId);
    }

    @Override
    public Film getFilmByName(String filmName) {
        return filmDao.getFilmByName(filmName);
    }

    @Override
    public List<Integer> getFilmIdByType(Integer typeId) {
        return filmDao.getFilmsByType(typeId);
    }


}
