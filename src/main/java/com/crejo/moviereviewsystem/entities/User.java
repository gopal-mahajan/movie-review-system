package com.crejo.moviereviewsystem.entities;

import com.crejo.moviereviewsystem.UserStatus;

import java.util.*;

public class User {
    private String name;
    private int reviewCount = 0;
    private UserStatus status = UserStatus.VIEWER;
    private Map<String, Integer> movieList=new HashMap<>();;

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

    public void setMovieList(String name,int review) {
        if(movieList.isEmpty())
        {

            movieList.put(name,review);
        }
        else{
            movieList.put(name,review);
        }
    }
}
