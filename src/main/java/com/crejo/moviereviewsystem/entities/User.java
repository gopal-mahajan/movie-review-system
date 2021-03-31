package com.crejo.moviereviewsystem.entities;

import com.crejo.moviereviewsystem.UserStatus;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class User {
    private final Map<String, Integer> movieList = new HashMap<>();
    private String name;
    private int reviewCount = 0;
    private UserStatus status = UserStatus.VIEWER;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Map<String, Integer> getMovieList() {
        return movieList;
    }

    public void setMovieList(String name, int review) {
        movieList.put(name, review);
    }

}
