package com.crejo.moviereviewsystem.controller;

import com.crejo.moviereviewsystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/addMovie")
    public void AddMovie(@RequestParam("movie_name") String name, @RequestParam("movie_release_date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
                         @RequestParam("movie_gener") String gener) {
        movieService.addMovie(name, date, gener);

    }


}
