package edu.fscj.cen3024c.gamepup.dto;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.entity.Game;

public class GameAccommodationDTO {
    private Accommodation accommodation;
    private Game game;

    public GameAccommodationDTO() {
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
}
