package com.hand.movie.bean;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer mobile;

    private String role;

    public User() {
    }

    public User(Integer userId, String username, String password, Integer mobile, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.role = role;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile=" + mobile +
                ", role='" + role + '\'' +
                '}';
    }
}