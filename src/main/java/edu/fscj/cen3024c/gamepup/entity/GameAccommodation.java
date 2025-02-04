// GameAccommodation.java
// 2/19/2024
// L. Nguyen and W. Money
// Class to represent many-to-many relationship between Accommodation and
// Game classes.

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "game_accommodation")
@IdClass(GameAccommodation.ID.class)
public class GameAccommodation {
    static class ID implements Serializable {
        private Accommodation accommodation;
        private Game game;

        @Override
        public boolean equals(Object that) {
            if (this == that)
                return true;
            if (that == null || this.getClass() != that.getClass())
                return false;

            ID id = (ID) that;

            return (this.accommodation == id.accommodation)
                    && (this.game == id.game);
        }

        @Override
        public int hashCode() {
            return Objects.hash(accommodation, game);
        }
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id", nullable = false)
    private Accommodation accommodation;

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = false)
    private Game game;

    public GameAccommodation() {
    }

    public GameAccommodation( Accommodation accommodation,
                             Game game) {
        this.accommodation = accommodation;
        this.game = game;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameAccommodation{" +
                "accommodation=" + accommodation +
                ", game=" + game +
                '}';
    }
}
