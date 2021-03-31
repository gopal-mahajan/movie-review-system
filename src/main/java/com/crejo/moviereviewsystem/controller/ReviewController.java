package com.crejo.moviereviewsystem.controller;

import com.crejo.moviereviewsystem.exception.AlreadyReviewedException;
import com.crejo.moviereviewsystem.exception.MovieNotReviewedException;
import com.crejo.moviereviewsystem.exception.NotAvailableException;
import com.crejo.moviereviewsystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public String addReview(@RequestParam("movie_name") String movieName, @RequestParam("user_name") String userName,
                            @RequestParam("movie_review") int review)
            throws AlreadyReviewedException {
        reviewService.addReview(movieName.toUpperCase(), userName.toUpperCase(), review);
        return "Review Added Successfully";
    }

    @GetMapping("/get")
    public String getReview(@RequestParam("movie_name") String movieName) throws MovieNotReviewedException {
        return reviewService.getReview(movieName.toUpperCase());
    }

    @GetMapping("/getByYear")
    public Map<String, Float> getReviewByYear(int year) {
        return reviewService.getReviewByYear(year);
    }

    @GetMapping("/getByGener")
    public Map<String, Float> getReviewByGener(@RequestParam("movie_gener") String gener,
                                               @RequestParam("no of movies") int n) throws NotAvailableException {
        return reviewService.getReviewByCritic(gener.toUpperCase(), n);
    }

}
