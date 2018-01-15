package com.hand.movie.bean;

import java.util.List;

public class ProjctionHall {
    private Integer projHallId;

    private String projectionHallName;

    private String broadcastingTime;

    private List<Seat> seat;



    public ProjctionHall() {
    }

    public ProjctionHall(Integer projHallId, String projectionHallName, String broadcastingTime) {
        this.projHallId = projHallId;
        this.projectionHallName = projectionHallName;
        this.broadcastingTime = broadcastingTime;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public Integer getProjHallId() {
        return projHallId;
    }

    public void setProjHallId(Integer projHallId) {
        this.projHallId = projHallId;
    }

    public String getProjectionHallName() {
        return projectionHallName;
    }

    public void setProjectionHallName(String projectionHallName) {
        this.projectionHallName = projectionHallName == null ? null : projectionHallName.trim();
    }

    public String getBroadcastingTime() {
        return broadcastingTime;
    }

    public void setBroadcastingTime(String broadcastingTime) {
        this.broadcastingTime = broadcastingTime == null ? null : broadcastingTime.trim();
    }

    @Override
    public String toString() {
        return "ProjctionHall{" +
                "projHallId=" + projHallId +
                ", projectionHallName='" + projectionHallName + '\'' +
                ", broadcastingTime='" + broadcastingTime + '\'' +
                '}';
    }
}