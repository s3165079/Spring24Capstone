// ReviewController.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.ReviewDTO;
import edu.fscj.cen3024c.gamepup.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){this.reviewService = reviewService;}

//    @PostMapping("/createreview")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ReviewDTO postReview(@Valid @RequestBody ReviewDTO reviewDTO,
//                                @RequestParam("username") String username)
//            throws NoSuchAlgorithmException, BadRequestException {
//
//        return reviewService.createReview(reviewDTO);
//    }

    @GetMapping("/{reviewRating}")
    public ResponseEntity<List<ReviewDTO>> getReviewByReviewRating(
            @PathVariable(value="reviewRating") int reviewRating){
        List<ReviewDTO> reviewDTOS =
                reviewService.getReviewByReviewRating(reviewRating);
        return ResponseEntity.ok().body(reviewDTOS);
    }
}
