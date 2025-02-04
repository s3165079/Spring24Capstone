package edu.fscj.cen3024c.gamepup.controller;


import edu.fscj.cen3024c.gamepup.dto.GameGenreDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.Genre;
import edu.fscj.cen3024c.gamepup.service.GameGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gamegenres")
public class GameGenreController {
    private final GameGenreService gameGenreService;

    @Autowired
    public GameGenreController(GameGenreService gameGenreService) {
        this.gameGenreService = gameGenreService;
    }

    @GetMapping
    public ResponseEntity<List<GameGenreDTO>> getAllGameGenreDTOs() {
        List<GameGenreDTO> gameGenreDTOs = gameGenreService.getAllGameGenreDTOs();
        return ResponseEntity.ok().body(gameGenreDTOs);
    }

    @GetMapping("/bygame/{game}")
    public ResponseEntity<List<GameGenreDTO>> getGameGenreDTOsByGame(
            @PathVariable(value = "game") Game game) {
        List<GameGenreDTO> gameGenreDTOs =
                gameGenreService.getGameGenreDTOsByGame(game);
        return ResponseEntity.ok().body(gameGenreDTOs);
    }

    @GetMapping("/bygenre/{genre}")
    public ResponseEntity<List<GameGenreDTO>> getGameGenreDTOsByGenre(
            @PathVariable(value = "genre") Genre genre) {
        List<GameGenreDTO> gameGenreDTOs =
                gameGenreService.getGameGenreDTOsByGenre(genre);
        return ResponseEntity.ok().body(gameGenreDTOs);
    }


}
