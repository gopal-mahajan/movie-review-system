package com.crejo.moviereviewsystem.controller;

import com.crejo.moviereviewsystem.UserStatus;
import com.crejo.moviereviewsystem.entities.Movie;
import com.crejo.moviereviewsystem.exception.AlreadyReviewedException;
import com.crejo.moviereviewsystem.exception.MovieNotReviewedException;
import com.crejo.moviereviewsystem.exception.NotAvailableException;
import com.crejo.moviereviewsystem.repository.MovieRepository;
import com.crejo.moviereviewsystem.repository.ReviewRepository;
import com.crejo.moviereviewsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController("/review")
public class ReviewController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ReviewRepository reviewRepository;


    @PostMapping("/addReview")
    public String addReview(@RequestParam("movie_name") String movieName, @RequestParam("user_name") String userName,
                            @RequestParam("movie_review") int review)
            throws AlreadyReviewedException {

        if ( userRepository.users.get(userName).getMovieList().containsKey(movieName)  ) {
            throw new AlreadyReviewedException("Cannot review again!");
        } else if (movieRepository.movieMap.get(movieName).getReleaseDate().isAfter(LocalDate.now())) {
            throw new AlreadyReviewedException("Cannot review movie prior to its release");
        } else {
            if (userRepository.users.get(userName).getReviewCount() < 3) {
                userRepository.users.get(userName).setMovieList(movieName, review);
                movieRepository.movieMap.get(movieName).addReview(userRepository.users.get(userName), review);
                userRepository.users.get(userName).setReviewCount(userRepository.users.get(userName).getReviewCount() + 1);
                if (userRepository.users.get(userName).getReviewCount() == 3) {
                    userRepository.users.get(userName).setStatus(UserStatus.CRITIC);
                }
            } else {
                movieRepository.addMovietoGenerMap(movieRepository.movieMap.get(movieName).getGenre(),movieName);
                userRepository.users.get(userName).setMovieList(movieName, review);
                movieRepository.movieMap.get(movieName).addReview(userRepository.users.get(userName), review );
                userRepository.users.get(userName).setReviewCount(userRepository.users.get(userName).getReviewCount() + 1);
            }
        }

        return "Review Added Successfully";
    }

    @GetMapping("/getReview")
    public String getReview(@RequestParam("movie_name") String movieName) throws MovieNotReviewedException {
       return reviewRepository.getReview(movieName);
    }

    @GetMapping("/getReviewbyYear")
    public Map<String, Float> getReviewByYear(int year){
        return reviewRepository.getReviewByYear(year);
    }

    @GetMapping("/getReviewbyGener")
    public Map<String,Float> getReviewbyGener(@RequestParam("movie_gener") String gener,@RequestParam("no of movies") int n) throws NotAvailableException {
        return reviewRepository.getReviewbyCritic(gener,n);
    }

}
