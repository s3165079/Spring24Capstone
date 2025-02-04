package edu.fscj.cen3024c.gamepup.controller;


import edu.fscj.cen3024c.gamepup.dto.GameAccommodationDTO;
import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.GameAccommodation;
import edu.fscj.cen3024c.gamepup.service.GameAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gameaccommodations")
public class GameAccommodationController {

    public final GameAccommodationService gameAccommodationService;

    @Autowired
    public GameAccommodationController(GameAccommodationService gameAccommodationService) {
        this.gameAccommodationService = gameAccommodationService;
    }

    @GetMapping
    public ResponseEntity<List<GameAccommodationDTO>> getAllGameAccommodations() {
        List<GameAccommodationDTO> gameAccommodationDTOs =
                gameAccommodationService
                .getAllGameAccommodationDTOs();
        return ResponseEntity.ok(gameAccommodationDTOs);
    }

    @GetMapping("/bygame/{game}")
    public ResponseEntity<List<GameAccommodationDTO>> getGameAccommodationByGame(
            @PathVariable(value = "game") Game game) {
        List<GameAccommodationDTO> gameAccommodationDTOs =
                gameAccommodationService.getGameAccommodationByGame(game);
        return ResponseEntity.ok(gameAccommodationDTOs);
    }

    @GetMapping("/byaccommodation/{accommodation}")
    public ResponseEntity<List<GameAccommodationDTO>> getGameAccommodationByAccommodation(
            @PathVariable(value = "accommodation") Accommodation accommodation) {
        List<GameAccommodationDTO> gameAccommodationDTOS =
                gameAccommodationService.getGameAccommodationByAccommodation(accommodation);
        return ResponseEntity.ok(gameAccommodationDTOS);
    }


}
