package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "game_console")
@IdClass(GameConsole.ID.class)
public class GameConsole {
    static class ID implements Serializable {
        private Game game;
        private Console console;

        @Override
        public boolean equals(Object that) {
            if (this == that)
                return true;
            if (that == null || this.getClass() != that.getClass())
                return false;

            ID id = (ID) that;

            return (this.game == id.game)
                    && (this.console == id.console);
        }

        @Override
        public int hashCode() {
            return Objects.hash(game, console);
        }
    }

    //fields
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = false)
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "console_id", referencedColumnName = "console_id", nullable = false)
    private Console console;

    @Column(name = "game_price")
    private BigDecimal gamePrice;

    //constuctor
    public GameConsole() {
    }

    //getters and setters
    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(BigDecimal gamePrice) {
        this.gamePrice = gamePrice;
    }
}
