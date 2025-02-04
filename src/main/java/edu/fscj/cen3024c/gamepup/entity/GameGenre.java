// GameGenre.java
// 2/19/2024
// L. Nguyen and W. Money
// Class to represent many-to-many relationship between Genre and
// Game classes.

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "game_genre")
@IdClass(GameGenre.ID.class)
public class GameGenre {
    static class ID implements Serializable {
        private Game game;
        private Genre genre;

        @Override
        public boolean equals(Object that) {
            if (this == that)
                return true;
            if (that == null || this.getClass() != that.getClass())
                return false;

            ID id = (ID) that;

            return (this.game == id.game)
                    && (this.genre == id.genre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(game, genre);
        }
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    public GameGenre() {
    }

    public GameGenre(Game game, Genre genre) {
        this.game = game;
        this.genre = genre;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "GameGenre{" +
                "game=" + game +
                ", genre=" + genre +
                '}';
    }
}
