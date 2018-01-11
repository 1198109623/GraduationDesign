package com.hand.movie.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;

public class Movie {
    private Integer movieId;

    private String movieName;

    private String director;

    private String stars;

    private String type;

    private String language;

    private String time;

    private String introduction;

    private Double price;

    private Date showTime;

    private byte[] picture;

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String director, String stars, String type, String language, String time, String introduction, Double price, Date showTime, byte[] picture) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.director = director;
        this.stars = stars;
        this.type = type;
        this.language = language;
        this.time = time;
        this.introduction = introduction;
        this.price = price;
        this.showTime = showTime;
        this.picture = picture;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars == null ? null : stars.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", stars='" + stars + '\'' +
                ", type='" + type + '\'' +
                ", language='" + language + '\'' +
                ", time='" + time + '\'' +
                ", introduction='" + introduction + '\'' +
                ", price=" + price +
                ", showTime=" + showTime +
                '}';
    }
}