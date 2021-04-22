package com.crejo.moviereviewsystem.service;

import com.crejo.moviereviewsystem.entities.Movie;
import com.crejo.moviereviewsystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MovieService {
    public Map<String, Float> getReviewByYear=new HashMap<>();
    public Map<String, Movie> getReviewByGener=new HashMap<>();



    @Autowired
    MovieRepository movieRepository;

    public void addMovie(String name, int date, String gener) {
        movieRepository.addMovietoMovieMap(name, new Movie(name, date, gener));
    }


    public boolean isMovieReleased(String movieName) {
        return getMovie(movieName).getReleaseDate()< LocalDate.now().getYear();
    }

    public Movie getMovie(String movieName) {
        return movieRepository.getMovie(movieName);
    }

    public void addMovietoGenerMap(String genre, String movieName) {
        movieRepository.addMovietoGenerMap(genre, movieName);
    }


    public Map<String, Float> getReviewByYear(int year) {
        System.out.println(year+" year");

        List<Movie> yearMovieMap = movieRepository.getMoviebyyear(year);
        System.out.println(yearMovieMap);
        for (Movie movie : yearMovieMap) {
            getReviewByYear.put(movie.getName(), movie.getReview());
        }
        return getReviewByYear;
    }

    public List<Movie> getReviewByGener(String gener) {

        return movieRepository.getMoviebygener(gener);

    }
}
