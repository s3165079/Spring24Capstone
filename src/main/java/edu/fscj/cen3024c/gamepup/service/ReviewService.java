// ReviewService.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameConverter;
import edu.fscj.cen3024c.gamepup.converter.ReviewConverter;
import edu.fscj.cen3024c.gamepup.converter.UserConverter;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import edu.fscj.cen3024c.gamepup.dto.ReviewDTO;
import edu.fscj.cen3024c.gamepup.dto.UserDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Review;
import edu.fscj.cen3024c.gamepup.entity.User;

import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.GameRepository;
import edu.fscj.cen3024c.gamepup.repository.ReviewRepository;
import edu.fscj.cen3024c.gamepup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final GameRepository gameRepository;
    private final GameConverter gameConverter;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository,
                         ReviewConverter reviewConverter,
                         UserRepository userRepository,
                         UserConverter userConverter,
                         GameRepository gameRepository,
                         GameConverter gameConverter) {
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.gameRepository = gameRepository;
        this.gameConverter = gameConverter;
    }

    public List<ReviewDTO> getAllReviewDTOs() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(reviewConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO getReviewDTOByReviewId(Integer reviewId) {
        Review review = reviewRepository.findByReviewId(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Review not found with reviewId: " + reviewId));
        return reviewConverter.convertToDTO(review);
    }

    public UserDTO getUserDTOByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Game not found with userId: " + userId));
        return userConverter.convertToDTO(user);
    }

    public GameDTO getGameDTOByGameId(Integer gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Game not found with gameId: " + gameId));
        return gameConverter.convertToGameDTO(game);
    }

    public List<ReviewDTO> getReviewByReviewRating(int rating) {
        List<Review> reviews = reviewRepository.findByReviewRating(rating);
        return reviews.stream().map(reviewConverter::convertToDTO).collect(Collectors.toList());
    }
}
