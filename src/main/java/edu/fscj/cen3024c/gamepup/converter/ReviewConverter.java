// ReviewConverter.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.entity.Review;
import edu.fscj.cen3024c.gamepup.dto.ReviewDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReviewConverter {

    // Review to DTO
    public ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();

        dto.setReviewContent(review.getReviewContent());
//        dto.setReviewDate(review.getReviewDate());
        dto.setReviewRating(review.getReviewRating());
//        dto.setReviewID(review.getReviewID());

        return dto;
    }

    // DTO to Review
    public Review convertToReview(ReviewDTO dto) {
        Review review = new Review();

        review.setReviewContent(dto.getReviewContent());
        review.setReviewDate(LocalDate.now());
        review.setReviewRating(dto.getReviewRating());
//        review.setReviewID(dto.getReviewID());

        return review;
    }
}
