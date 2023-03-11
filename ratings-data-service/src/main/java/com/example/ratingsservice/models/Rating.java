package com.example.ratingsservice.models;

import javax.persistence.*;

@Entity
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue
    @Column(name = "ratingid")
    private Long ratingId;
    @Column(name = "movieid")
    private String movieId;
    @Column(name = "rating")
    private int rating;


    public Rating() {
    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
