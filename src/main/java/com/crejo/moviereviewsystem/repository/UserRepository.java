package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        System.out.println(user);
        users.put(user.getName(), user);

    }

    public User getUser(String userName) {
        return users.get(userName);
    }

}
