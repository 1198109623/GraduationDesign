package com.hand.movie.bean;

import java.util.List;

public class Cinema {
    private Integer cinemaId;

    private String cinemaName;

    private String address;

    private String telephone;

    private Integer pId;

    private List<ProjctionHall> projctionHall;

    private List<CinemaProjectionHall> cinemaProjectionHalls;




    public Cinema() {
    }

    public Cinema(Integer cinemaId, String cinemaName, String address, String telephone) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.telephone = telephone;
    }

    public List<CinemaProjectionHall> getCinemaProjectionHalls() {
        return cinemaProjectionHalls;
    }

    public void setCinemaProjectionHalls(List<CinemaProjectionHall> cinemaProjectionHalls) {
        this.cinemaProjectionHalls = cinemaProjectionHalls;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public List<ProjctionHall> getProjctionHall() {
        return projctionHall;
    }

    public void setProjctionHall(List<ProjctionHall> projctionHall) {
        this.projctionHall = projctionHall;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName == null ? null : cinemaName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", projctionHall=" + projctionHall +
                ", cinemaProjectionHalls=" + cinemaProjectionHalls +
                '}';
    }
}