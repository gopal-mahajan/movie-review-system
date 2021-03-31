package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.entities.Movie;
import com.crejo.moviereviewsystem.exception.MovieNotReviewedException;
import com.crejo.moviereviewsystem.exception.NotAvailableException;
import com.crejo.moviereviewsystem.service.MovieService;
import com.crejo.moviereviewsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Repository
public class ReviewRepository {

    public Map<String, Float> getReviewByYear;
    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    public Map<String, Float> getReviewByYear(int year) {
        return movieService.getReviewByYear(year);
    }

    public String getReview(String movieName) throws MovieNotReviewedException {
        Movie movie = movieService.getMovie(movieName);
        if (movie.getNoOfReviews() == 0) {
            throw new MovieNotReviewedException("Movie not reviewed yet!");
        } else
            return "Average rating for " + movieName + " is " + movie.getReview() + " and critic rating is " + movie.getCritic_review();

    }

    public Map<String, Float> getReviewbyCritic(String gener, int n) throws NotAvailableException {
        HashMap<String, Float> criticReview = new HashMap<>();
        HashMap<String, Float> criticReview1 = new HashMap<>();

        for (Movie movie : movieService.getReviewByGener(gener)) {
            criticReview.put(movie.getName(), movie.getCritic_review());
        }
        if (criticReview.size() < n)
            throw new NotAvailableException("Required number of movies not available");
        else {
            criticReview = criticReview.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

            int i = 0;
            for (Map.Entry<String, Float> entry : criticReview.entrySet()) {

                criticReview1.put(entry.getKey(), entry.getValue());
                i++;

                if (i == n)
                    break;
            }
        }
        return criticReview1;
    }
}




