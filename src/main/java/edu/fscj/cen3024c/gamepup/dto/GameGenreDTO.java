package edu.fscj.cen3024c.gamepup.dto;

import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Genre;

public class GameGenreDTO {

    private Game game;

    private Genre genre;

    public GameGenreDTO() {
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
}
