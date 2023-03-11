package com.example.ratingsservice.repos;

import com.example.ratingsservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

}
