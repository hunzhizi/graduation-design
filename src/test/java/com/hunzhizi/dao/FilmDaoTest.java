package com.hunzhizi.dao;

import com.hunzhizi.GraduationDesignApplication;
import com.hunzhizi.domain.Film;
import com.hunzhizi.enums.FilmType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-11 20:34
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class FilmDaoTest {
    @Resource
    private FilmDao test;

    @Test
    public void createFilm() {
        Film film = new Film();
        film.setDesc("星际穿越");
        film.setType(FilmType.ACTION);
        System.out.println(test.createFilm(film));
    }

    @Test
    public void getAllFilms() {
        List<Film> allFilms = test.getAllFilms();
        for (Film allFilm : allFilms) {
            System.out.println(allFilm.getFilmId() +
                    allFilm.getDesc() +
                    allFilm.getType());
        }

    }

    @Test
    public void getFilmsByType() {
        Film filmByType = test.getFilmsById(1);

        System.out.println(filmByType.getFilmId() +
                filmByType.getDesc() +
                filmByType.getType());

    }

    @Test
    public void getFilmByName(){
        Film filmByName = test.getFilmByName("魔兽");
        System.out.println(filmByName==null);
        Film filmByName1 = test.getFilmByName("飞天魔警\n");
        System.out.println(filmByName1==null);

    }

}
