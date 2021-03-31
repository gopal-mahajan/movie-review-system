package com.crejo.moviereviewsystem.controller;

import com.crejo.moviereviewsystem.entities.User;
import com.crejo.moviereviewsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

 @Autowired
    UserService userService;

    @PostMapping("/addUser")
    void addUser(@RequestParam("user_name") String name){
        userService.addUser(name);

    }

}
