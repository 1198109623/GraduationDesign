package com.hand.movie.bean;

public class CinemaProjectionHall {
    private Integer id;

    private Integer cinemaId;

    private Integer projectionHallId;

    public CinemaProjectionHall() {
    }

    public CinemaProjectionHall(Integer id, Integer cinemaId, Integer projectionHallId) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.projectionHallId = projectionHallId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getProjectionHallId() {
        return projectionHallId;
    }

    public void setProjectionHallId(Integer projectionHallId) {
        this.projectionHallId = projectionHallId;
    }

    @Override
    public String toString() {
        return "CinemaProjectionHall{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", projectionHallId=" + projectionHallId +
                '}';
    }
}