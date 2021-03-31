package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.entities.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MovieRepository {

    private Map<String, Movie> movieMap = new HashMap<>();
    private Map<String, Float> getReviewByYear;
    private Map<Integer, List<String>> yearMovieMap = new HashMap<>();
    private Map<String, List<String>> generMovieMap = new HashMap<>();

    public Movie getMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public void setMovieMap(Map<String, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public Map<String, Float> getGetReviewByYear() {
        return getReviewByYear;
    }

    public void setGetReviewByYear(Map<String, Float> getReviewByYear) {
        this.getReviewByYear = getReviewByYear;
    }

    public Map<Integer, List<String>> getYearMovieMap() {
        return yearMovieMap;
    }

    public void setYearMovieMap(Map<Integer, List<String>> yearMovieMap) {
        this.yearMovieMap = yearMovieMap;
    }

    public Map<String, List<String>> getGenerMovieMap() {
        return generMovieMap;
    }

    public void setGenerMovieMap(Map<String, List<String>> generMovieMap) {
        this.generMovieMap = generMovieMap;
    }

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
        addMovieYearMap(movie.getReleaseDate(), movie.getName());
    }

    public List<Movie> getMoviebyyear(int year) {
        List<String> moviebyYear = yearMovieMap.get(year);
        List<Movie> movies = new ArrayList<>();
        for (String movie : moviebyYear) {
            movies.add(movieMap.get(movie));
        }
        return movies;
    }

    public List<Movie> getMoviebygener(String gener) {
        List<String> moviebygener = generMovieMap.getOrDefault(gener,new ArrayList<>());
        List<Movie> movies = new ArrayList<>();
        for (String movie : moviebygener) {
            movies.add(movieMap.get(movie));
        }
        return movies;
    }

}