package com.hand.movie.bean;

public class Evaluation {
    private Integer evaluationId;

    private Integer userId;

    private Integer movieId;

    private String evaluationContent;

    private User user;

//    private Movie movie;

    public Evaluation() {
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent == null ? null : evaluationContent.trim();
    }

//    @Override
//    public String toString() {
//        return "Evaluation{" +
//                "evaluationId=" + evaluationId +
//                ", userId=" + userId +
//                ", movieId=" + movieId +
//                ", evaluationContent='" + evaluationContent + '\'' +
//                ", user=" + user +
//                ", movie=" + movie +
//                '}';
//    }
}