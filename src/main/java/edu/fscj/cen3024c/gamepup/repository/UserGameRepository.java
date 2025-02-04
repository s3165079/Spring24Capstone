// UserGameRepository.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Review;
import edu.fscj.cen3024c.gamepup.entity.User;
import edu.fscj.cen3024c.gamepup.entity.UserGame;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGameRepository extends JpaRepository<UserGame, Integer> {
    //Find by User
    List<UserGame> findByUser(User user);

    List<UserGame> findByUserId(Integer userId);

    //Find by Game
    List<UserGame> findByGame(Game game);

    List<UserGame> findByGameId(Integer gameId);

    //Find by Review
    UserGame findByReview(Review review);

    List<UserGame> findByReviewReviewId(Integer reviewId);

    List<UserGame> findByUserAndGame(User user, Game game);

    List<UserGame> findReviewByGame(Game game);
}