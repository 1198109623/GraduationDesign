package com.hand.movie.bean;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer userId;

    private Integer cinemaId;

    private Integer mphId;

    private String seatNum;

    private String orderCode;

    private Date creationDate;

    private User user;

    private Cinema cinema;

    private ProjctionHall projctionHall;

    private Movie movie;

    private MovieProjHall mph;

    public Order() {
    }

    public Order(Integer orderId, Integer userId, Integer cinemaId, Integer mphId, String seatNum, String orderCode) {
        this.orderId = orderId;
        this.userId = userId;
        this.cinemaId = cinemaId;
        this.mphId = mphId;
        this.seatNum = seatNum;
        this.orderCode = orderCode;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public MovieProjHall getMph() {
        return mph;
    }

    public void setMph(MovieProjHall mph) {
        this.mph = mph;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getMphId() {
        return mphId;
    }

    public void setMphId(Integer mphId) {
        this.mphId = mphId;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum == null ? null : seatNum.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", cinemaId=" + cinemaId +
                ", mphId=" + mphId +
                ", seatNum='" + seatNum + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", creationDate=" + creationDate +
                ", user=" + user +
                ", cinema=" + cinema +
                ", projctionHall=" + projctionHall +
                ", movie=" + movie +
                ", mph=" + mph +
                '}';
    }
}