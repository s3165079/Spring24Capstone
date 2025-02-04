// ReviewRepository.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //find by id
    Optional<Review> findByReviewId(Integer id);
    List<Review> findByReviewRating(int reviewRating);

//    List<Review> findByGame
}