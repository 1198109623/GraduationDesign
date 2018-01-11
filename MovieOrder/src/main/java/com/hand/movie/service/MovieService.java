package com.hand.movie.service;

import com.hand.movie.bean.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getMovieByName(String movieName);

    int saveMovie(Movie movie);

    Movie getMovie(Integer id);

    void updateMovie(Movie movie);

    void deleteMovie(Integer id);

    void deleteBatch(List<Integer> ids);
}
