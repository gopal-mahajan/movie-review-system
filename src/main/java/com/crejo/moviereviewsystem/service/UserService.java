package com.crejo.moviereviewsystem.service;

import com.crejo.moviereviewsystem.entities.User;
import com.crejo.moviereviewsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String name) {
        userRepository.addUser(new User(name));
    }

    public boolean userReviewedAlready(String userName, String movieName) {
        return userRepository.getUser(userName).getMovieList().containsKey(movieName);
    }

    public User getUser(String userName) {
        return userRepository.getUser(userName);
    }
}
