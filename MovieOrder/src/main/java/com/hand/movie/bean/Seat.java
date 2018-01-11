package com.hand.movie.bean;

public class Seat {
    private Integer seatId;

    private Integer row;

    private Integer seat;

    private Integer status;

    public Seat() {
    }

    public Seat(Integer seatId, Integer row, Integer seat, Integer status) {
        this.seatId = seatId;
        this.row = row;
        this.seat = seat;
        this.status = status;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", seat=" + seat +
                ", status=" + status +
                '}';
    }
}