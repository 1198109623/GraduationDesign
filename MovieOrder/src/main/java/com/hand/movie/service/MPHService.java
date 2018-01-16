package com.hand.movie.service;

import com.hand.movie.bean.Movie;
import com.hand.movie.bean.MovieProjHall;

import java.util.List;

public interface MPHService {
    List<MovieProjHall> getAll();

    List<MovieProjHall> getMPHBypName(String pName);

    int saveMPH(MovieProjHall movieProjHall);

    MovieProjHall getMPById(Integer id);

    void updateMPH(MovieProjHall mph);

    void deleteMPH(Integer id);

    void deleteBatch(List<Integer> ids);

}
