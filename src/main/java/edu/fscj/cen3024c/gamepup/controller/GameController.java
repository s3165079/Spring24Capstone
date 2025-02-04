package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.converter.GameConverter;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.exceptions.NoParametersException;
import edu.fscj.cen3024c.gamepup.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameConverter gameConverter;

    @Autowired
    public GameController(GameService gameService,
                          GameConverter gameConverter) {
        this.gameService = gameService;
        this.gameConverter = gameConverter;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<GameDTO> gameDTOs = gameService.getAllGameDTOs();
        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<GameDTO>> getGameByDetails(
      @RequestParam Optional<String> gameName,
      @RequestParam Optional<String> maturityRating
      ){
        ResponseEntity<List<GameDTO>> retGames;
        if(gameName.isPresent()){
            retGames = getGameByGameName(gameName.get());
        }else if(maturityRating.isPresent()){
            retGames = getGameDTOByMaturityRating(maturityRating.get());
        }else{
           throw new NoParametersException("No input parameters found.");
        }

        return retGames;
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameDTO> getGameByGameId(
      @PathVariable("gameId") Integer gameId){
        GameDTO gameDTO = gameService.getGameDTOByGameId(gameId);
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("/findByName/{gameName}")
    public ResponseEntity<List<GameDTO>> getGameByGameName(
      @PathVariable("gameName") String gameName){
        List<GameDTO> gameDTOs = gameService.getGameDTOsByGameName(gameName);
        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/findByMaturityRating/{maturityRating}")
    public ResponseEntity<List<GameDTO>> getGameDTOByMaturityRating(
      @PathVariable("maturityRating") String maturityRating){
        List<GameDTO> gameDTOs = gameService.getGameDTOsByMaturityRating(maturityRating);
        return ResponseEntity.ok(gameDTOs);
    }

    //added 04/16/2024 for search by multiplayer/online play
    @GetMapping("/findByIsCoOp/{isCoOp}")
    public ResponseEntity<List<GameDTO>> getGameDTOByIsCoOp(
            @PathVariable("isCoOp") boolean isCoOp){
        List<GameDTO> gameDTOs = gameService.getGameDTOsByIsCoOp(isCoOp);
        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/findByIsOnline/{isOnline}")
    public ResponseEntity<List<GameDTO>> getGameDTOByIsOnline(
            @PathVariable("isOnline") boolean isOnline){
        List<GameDTO> gameDTOs = gameService.getGameDTOsByIsOnline(isOnline);
        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/findByPlayTimeAndRating")
    public ResponseEntity<List<GameDTO>> getGameByPlayTimeAndReviewRating(
            @RequestParam Optional<Integer> playTime,
            @RequestParam Optional<Integer> reviewRating) {

        List<GameDTO> matchingGames = new ArrayList<>();

        if (playTime.isPresent() || reviewRating.isPresent()) {
            // Loop through all games
            for (Game game : gameService.getAllGames()) {
                // Check if the game's playTime is less than the specified playTime (if provided)
                if (playTime.isPresent() && game.getPlayTime() < playTime.get()) {
                    // Check if the game's reviewRating matches the specified reviewRating (if provided)
                    if (reviewRating.isPresent() && game.getAvgReviewRating() == reviewRating.get()) {
                        // Convert the Game object to GameDTO and add it to the matching games list
                        matchingGames.add(gameConverter.convertToGameDTO(game));
                    }
                }
            }
            return ResponseEntity.ok(matchingGames);
        } else {
            throw new NoParametersException("No input parameters found.");
        }
    }


}
