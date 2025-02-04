package edu.fscj.cen3024c.gamepup.dto;

import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Review;
import edu.fscj.cen3024c.gamepup.entity.User;

public class UserGameDTO {
    private User user;
    private Game game;
    private Review review;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
