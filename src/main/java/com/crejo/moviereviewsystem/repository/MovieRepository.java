package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.entities.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MovieRepository {

    public Map<String, Movie> movieMap = new HashMap<>();
    public Map<String, Float> getReviewByYear;
    public Map<Integer, List<String>> yearMovieMap = new HashMap<>();
    public  Map<String, List<String>> generMovieMap = new HashMap<>();

    private void addMovieYearMap(int year, String name) {
        List<String> movieList = yearMovieMap.getOrDefault(year, new ArrayList<String>());
        movieList.add(name);
        yearMovieMap.put(year, movieList);
    }

    public void addMovietoGenerMap(String gener, String name) {
        List<String> movieList = generMovieMap.getOrDefault(gener, new ArrayList<String>());
        movieList.add(name);
        generMovieMap.put(gener, movieList);
    }

    public void addMovietoMovieMap(String name, Movie movie) {
        movieMap.put(name, movie);
//        addMovietoGenerMap(movie.getGenre(), movie.getName());
        addMovieYearMap(movie.getReleaseDate().getYear(), movie.getName());
    }

}