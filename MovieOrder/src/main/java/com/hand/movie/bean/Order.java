package com.hand.movie.bean;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer userId;

    private Double orderPrice;

    private String orderContent;

    private Date creationDate;

    private String cinemaName;

    private Date showtime;

    private String projectionHallName;

    private String seatNum;

    private User user;

    public Order() {
    }

    public Order(Integer orderId, Integer userId, Double orderPrice, String orderContent, Date creationDate, String cinemaName, Date showtime, String projectionHallName, String seatNum, User user) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderContent = orderContent;
        this.creationDate = creationDate;
        this.cinemaName = cinemaName;
        this.showtime = showtime;
        this.projectionHallName = projectionHallName;
        this.seatNum = seatNum;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent == null ? null : orderContent.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName == null ? null : cinemaName.trim();
    }

    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }

    public String getProjectionHallName() {
        return projectionHallName;
    }

    public void setProjectionHallName(String projectionHallName) {
        this.projectionHallName = projectionHallName == null ? null : projectionHallName.trim();
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum == null ? null : seatNum.trim();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", orderContent='" + orderContent + '\'' +
                ", creationDate=" + creationDate +
                ", cinemaName='" + cinemaName + '\'' +
                ", showtime=" + showtime +
                ", projectionHallName='" + projectionHallName + '\'' +
                ", seatNum='" + seatNum + '\'' +
                ", user=" + user +
                '}';
    }
}