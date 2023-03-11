package com.example.movieinfoservice.repos;

import com.example.movieinfoservice.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
}
