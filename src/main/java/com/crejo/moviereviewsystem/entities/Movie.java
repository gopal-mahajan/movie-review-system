package com.crejo.moviereviewsystem.entities;

import com.crejo.moviereviewsystem.UserStatus;

import java.time.LocalDate;

public class Movie {


    private String name;
    private LocalDate releaseDate;

    private String genre;
    private float review;
    private int noOfReviews;
    private int noOfCriticReviews;
    private float critic_review;

    public Movie(String name, LocalDate date, String genre) {
        this.name = name;
        this.releaseDate = date;
        this.genre = genre;
    }

    public void addReview(User user, int review) {
        if (user.getStatus().equals(UserStatus.CRITIC)) {
            this.critic_review = (this.critic_review * noOfCriticReviews + ((review)*2) * 1.0f / (++noOfCriticReviews));
        }
        else
            this.review = (this.review * noOfReviews + review) / (++noOfReviews);
    }


//    private Map<User, Float> movieReview;
//

//    horror,thriller,comedy,drama,romance,action

    public float getCritic_review() {

        return critic_review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getNoOfReviews() {
        return noOfReviews;
    }



//    public void setMovieReview(User user, float review) {
//        if (movieReview.isEmpty()) {
//            movieReview = new HashMap<>();
//            movieReview.put(user, review);
//        } else {
//            movieReview.put(user, review);
//
//        }
//    }
//
//    public float getMovieReview() throws MovieNotReviewed {
//        if (movieReview.isEmpty()) {
//            throw new MovieNotReviewed("Movie not reviewed yet!");
//        } else {
//            int sum=0;
//            for (Map.Entry<User, Float> moviereview : movieReview.entrySet()) {
//                sum+=moviereview.getValue();
//            }
//            return sum/movieReview.size();
//        }
//    }


}
