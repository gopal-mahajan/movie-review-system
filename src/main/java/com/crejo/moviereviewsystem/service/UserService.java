package com.crejo.moviereviewsystem.service;

import com.crejo.moviereviewsystem.entities.User;
import com.crejo.moviereviewsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String name) {
        userRepository.addUser(new User(name));
    }
}
