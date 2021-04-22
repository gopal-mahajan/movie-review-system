package com.crejo.moviereviewsystem.entities;

import com.crejo.moviereviewsystem.UserStatus;



public class Movie {


    private String name;
    private int releaseDate;

    private String genre;
    private float review;
    private int noOfReviews;
    private int noOfCriticReviews;
    private float critic_review;

    public Movie(String name, int date, String genre) {

        this.name = name;
        this.releaseDate = date;
        this.genre = genre;
    }

    public void addReview(User user, int review) {
        if (user.getStatus().equals(UserStatus.CRITIC)) {
            this.critic_review = (this.critic_review * noOfCriticReviews + ((review) * 2) * 1.0f / (++noOfCriticReviews));
        } else
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

    public int getReleaseDate() {
        return releaseDate;
    }



    public void setReleaseDate(int releaseDate) {
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
        return noOfReviews+noOfCriticReviews;
    }


}
