package com.hand.movie.bean;

public class MovieProjectionHall {
    private Integer id;

    private Integer movieId;

    private Integer projectionHallId;

    public MovieProjectionHall() {
    }

    public MovieProjectionHall(Integer id, Integer movieId, Integer projectionHallId) {
        this.id = id;
        this.movieId = movieId;
        this.projectionHallId = projectionHallId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getProjectionHallId() {
        return projectionHallId;
    }

    public void setProjectionHallId(Integer projectionHallId) {
        this.projectionHallId = projectionHallId;
    }

    @Override
    public String toString() {
        return "MovieProjectionHall{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", projectionHallId=" + projectionHallId +
                '}';
    }
}