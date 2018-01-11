package com.hand.movie.service;

import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.CinemaExample;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAll();

    Cinema getCinemaWithProjHall(Integer id);

    Cinema getCinema(Integer id);

    List<Cinema> getCinemaByName(String cinemaName);

    int saveCinema(Cinema cinema);

    void updateCinema(Cinema cinema);

    void deleteEmp(Integer id);

    void deleteBatch(List<Integer> ids);

}
