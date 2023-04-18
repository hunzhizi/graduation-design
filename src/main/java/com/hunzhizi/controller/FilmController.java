package com.hunzhizi.controller;

import com.hunzhizi.controller.result.Result;
import com.hunzhizi.domain.Film;
import com.hunzhizi.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2023-03-15 23:08
 * program: graduation-design
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/film")
public class FilmController {
    @Resource
    FilmService service;

    @GetMapping("/filmDesc/{filmId}")
    public Result getFilmById(@PathVariable Integer filmId){
        Film film = service.getFilmByFilmId(filmId);
        return new Result(1,film);
    }

}
