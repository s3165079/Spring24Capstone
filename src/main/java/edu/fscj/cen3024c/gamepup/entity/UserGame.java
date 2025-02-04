// UserGame.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_game")
@IdClass(UserGame.ID.class)
public class UserGame {
    // replace user and game with UserGameId
    static class ID implements Serializable {
        private User user;
        private Game game;

        @Override
        public boolean equals(Object that) {
            if (this == that)
                return true;
            if (that == null || this.getClass() != that.getClass())
                return false;

            ID id = (ID) that;

            return Objects.equals(this.user.getId(), id.user.getId())
                    && Objects.equals(this.game.getId(), id.game.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(user.getId(), game.getId());
        }
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
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

    @Override
    public String toString() {
        return "UserGame { " +
                "user=" + user +
                ", game=" + game +
                ", review=" + review +
                " }";
    }
}