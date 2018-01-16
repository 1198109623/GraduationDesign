package com.hand.movie.bean;

import java.util.Date;

public class MovieProjHall {
    private Integer id;

    private Integer movieId;

    private Integer projectionHallId;

    private Date mpTime;

    private Double mpPrice;

    private ProjctionHall projctionHall;

    private Movie movie;

    public MovieProjHall() {
    }

    public MovieProjHall(Integer id, Integer movieId, Integer projectionHallId, Date mpTime, Double mpPrice) {
        this.id = id;
        this.movieId = movieId;
        this.projectionHallId = projectionHallId;
        this.mpTime = mpTime;
        this.mpPrice = mpPrice;
    }

    public ProjctionHall getProjctionHall() {
        return projctionHall;
    }

    public void setProjctionHall(ProjctionHall projctionHall) {
        this.projctionHall = projctionHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public Date getMpTime() {
        return mpTime;
    }

    public void setMpTime(Date mpTime) {
        this.mpTime = mpTime;
    }

    public Double getMpPrice() {
        return mpPrice;
    }

    public void setMpPrice(Double mpPrice) {
        this.mpPrice = mpPrice;
    }

    @Override
    public String toString() {
        return "MovieProjHall{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", projectionHallId=" + projectionHallId +
                ", mpTime=" + mpTime +
                ", mpPrice=" + mpPrice +
                ", projctionHall=" + projctionHall +
                ", movie=" + movie +
                '}';
    }
}