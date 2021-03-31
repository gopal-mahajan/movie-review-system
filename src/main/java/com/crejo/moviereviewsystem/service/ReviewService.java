package com.crejo.moviereviewsystem.service;

import com.crejo.moviereviewsystem.UserStatus;
import com.crejo.moviereviewsystem.entities.Movie;
import com.crejo.moviereviewsystem.entities.User;
import com.crejo.moviereviewsystem.exception.AlreadyReviewedException;
import com.crejo.moviereviewsystem.exception.MovieNotReviewedException;
import com.crejo.moviereviewsystem.exception.NotAvailableException;
import com.crejo.moviereviewsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserService userService;
    @Autowired
    MovieService movieService;

    private void validateAddReviewRequest(String userName, String movieName) throws AlreadyReviewedException {
        if (userService.userReviewedAlready(userName, movieName)) {
            throw new AlreadyReviewedException("Cannot review again!");
        } else if (!movieService.isMovieReleased(movieName)) {
            throw new AlreadyReviewedException("Cannot review movie prior to its release");
        }
    }

    public void addReview(String movieName, String userName, int review) throws AlreadyReviewedException {
        validateAddReviewRequest(userName, movieName);
        User user = userService.getUser(userName);
        Movie movie = movieService.getMovie(movieName);
        if (user.getReviewCount() < 3) {
            user.setMovieList(movieName, review);
            movie.addReview(user, review);
            user.setReviewCount(user.getReviewCount() + 1);
            if (user.getReviewCount() == 3) {
                user.setStatus(UserStatus.CRITIC);
            }
        } else {
            movieService.addMovietoGenerMap(movie.getGenre(), movieName);
            user.setMovieList(movieName, review);
            movie.addReview(user, review);
            user.setReviewCount(user.getReviewCount() + 1);
        }
    }


    public String getReview(String movieName) throws MovieNotReviewedException {
        return reviewRepository.getReview(movieName);
    }


    public Map<String, Float> getReviewByCritic(String gener, int n) throws NotAvailableException {
        return reviewRepository.getReviewbyCritic(gener, n);
    }

    public Map<String, Float> getReviewByYear(int year) {
        return movieService.getReviewByYear(year);
    }
}
