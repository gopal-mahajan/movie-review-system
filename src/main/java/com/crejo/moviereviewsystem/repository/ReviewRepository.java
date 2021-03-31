package com.crejo.moviereviewsystem.repository;

import com.crejo.moviereviewsystem.exception.MovieNotReviewedException;
import com.crejo.moviereviewsystem.exception.NotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.stream.Collectors.toMap;

@Repository
public class ReviewRepository {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    public Map<String, Float> getReviewByYear;

    public Map<String, Float> getReviewByYear(int year) {
        getReviewByYear = new HashMap<>();
        for (String movieName : movieRepository.yearMovieMap.get(year)) {
            getReviewByYear.put(movieName, movieRepository.movieMap.get(movieName).getReview());
        }
        return getReviewByYear;
    }

    public String getReview(String movieName) throws MovieNotReviewedException {
        if (movieRepository.movieMap.get(movieName).getNoOfReviews() == 0) {
            throw new MovieNotReviewedException("Movie not reviewed yet!");
        } else
            return "Average rating for " + movieRepository.movieMap.get(movieName) + " is " +
                    movieRepository.movieMap.get(movieName).getReview() + " and critic rating is "
                    + movieRepository.movieMap.get(movieName).getCritic_review();

    }

    public Map<String, Float> getReviewbyCritic(String gener, int n) throws NotAvailableException {
        HashMap<String, Float> criticReview = new HashMap<>();
        HashMap<String, Float> criticReview1 = new HashMap<>();

        for (String movieName : movieRepository.generMovieMap.get(gener)) {
            criticReview.put(movieName, movieRepository.movieMap.get(movieName).getCritic_review());
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

                if(i==n)
                    break;
            }
        }
        return criticReview1;
    }
}




