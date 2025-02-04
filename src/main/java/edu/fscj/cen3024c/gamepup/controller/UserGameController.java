package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.converter.GameConverter;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import edu.fscj.cen3024c.gamepup.dto.ReviewDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.exceptions.NoParametersException;

import edu.fscj.cen3024c.gamepup.service.GameService;
import edu.fscj.cen3024c.gamepup.service.UserGameService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userGame")
public class UserGameController {
    private final UserGameService userGameService;
    private final GameService gameService;
    private final GameConverter gameConverter;

    @Autowired
    public UserGameController(UserGameService userGameService,
                              GameService gameService,
                              GameConverter gameConverter) {
        this.userGameService = userGameService;
        this.gameService = gameService;
        this.gameConverter = gameConverter;
    }

    @GetMapping("/showUsersGameCollection")
    public ResponseEntity<List<GameDTO>> getGamesByUserName(
            @RequestParam String userName)
            throws BadRequestException{
        List<GameDTO> gameDTOS =  userGameService.findGamesByUserName(userName);
        return ResponseEntity.ok(gameDTOS);
    }


    @GetMapping("/findByPlayTimeAndRating/{gameName}")
    public ResponseEntity<List<GameDTO>> getGameByGamePlayTimeAndReviewRating(
            @RequestParam Optional<Integer> gamePlayTime,
            @RequestParam Optional<Integer> reviewRating) {

        List<GameDTO> gameDTOs = gameService.getAllGameDTOs();
        List<Game> games = gameDTOs.stream()
                .map(gameConverter::convertToGame)
                .toList();
        List<Game> matchingGames = null;
        List<GameDTO> matchingGameDTOs;

        if (gamePlayTime.isPresent() && reviewRating.isPresent()) {
            boolean meetsCriteria = false;
            double highRating = 4;
            for (Game game : games) {
                meetsCriteria = true;

                if (game.getPlayTime() >= gamePlayTime.get()) {
                    meetsCriteria = false;
                }

                if (reviewRating.isPresent()) {
                    userGameService.calculateAverageRating(game);
                    double averageRating = game.getAvgReviewRating();
                    if (averageRating > highRating)
                        meetsCriteria = false;
                }
                if (meetsCriteria) {
                    matchingGames.add(game);
                }
            }
            matchingGameDTOs = matchingGames.stream()
                    .map(gameConverter::convertToGameDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(matchingGameDTOs);
        } else {
            throw new NoParametersException("No input parameters found.");
        }
    }

    @PostMapping("/createreview")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDTO postReview(@Valid @RequestBody ReviewDTO reviewDTO,
                                @RequestParam("username") String userName,
                                @RequestParam("gamename") String gameName)
            throws BadRequestException {

        return userGameService.createReview(reviewDTO, userName, gameName);
    }

    @PutMapping("/updatereview")
    public ReviewDTO updateReview(
            @Valid @RequestBody ReviewDTO reviewDTO,
            @RequestParam("username") String userName,
            @RequestParam("gamename") String gameName)
            throws BadRequestException {

        return userGameService.updateReview(reviewDTO, userName, gameName);
    }

    @PutMapping("/addgametocollection")
    public List<String> addGameToUserCollection(
            @RequestParam("username") String userName,
            @RequestParam("gamename") String gameName)
            throws BadRequestException {

        return userGameService.addGameToUser(userName, gameName);
    }
    @PutMapping("/removegamefromcollection")
    public List<String> removeGameFromUser(
            @RequestParam("username") String userName,
            @RequestParam("gamename") String gameName)
            throws BadRequestException {

        return userGameService.removeGameFromUser(userName, gameName);
    }
}
