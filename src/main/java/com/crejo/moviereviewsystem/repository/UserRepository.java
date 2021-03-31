package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    public Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

}
