package com.crejo.moviereviewsystem.service;

import com.crejo.moviereviewsystem.entities.Movie;
import com.crejo.moviereviewsystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(String name, LocalDate date, String gener) {
        movieRepository.addMovietoMovieMap(name,new Movie(name,date,gener));
    }




}
