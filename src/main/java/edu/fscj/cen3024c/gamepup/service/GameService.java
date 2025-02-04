package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameConverter;
import edu.fscj.cen3024c.gamepup.dto.GameDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
  private final GameRepository gameRepository;
  private final GameConverter gameConverter;

    @Autowired
  public GameService(GameRepository gameRepository,
                     GameConverter gameConverter) {
    this.gameRepository = gameRepository;
    this.gameConverter = gameConverter;
    }

  public List<Game> getAllGames() {
    return gameRepository.findAll();
  }

  public List<GameDTO> getAllGameDTOs() {
    List<Game> games = gameRepository.findAll();
    return games.stream().map(gameConverter::convertToGameDTO)
        .collect(Collectors.toList());
  }

  public GameDTO getGameDTOByGameId(Integer gameId) {
    Game game = gameRepository.findById(gameId)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Game not found with gameId: " + gameId));
    return gameConverter.convertToGameDTO(game);
  }

  public List<GameDTO> getGameDTOsByGameName(String gameName) {
    //replace char sequence from URL with space
    if (gameName.contains("%20") || gameName.contains("%3A")) {
      gameName = gameName
              .replace("%20", " ")
              .replace("%3A", ":");
    }

    List<Game> games = gameRepository.findByGameName(gameName);
    return games.stream().map(gameConverter::convertToGameDTO)
        .collect(Collectors.toList());
  }

  public List<GameDTO> getGameDTOsByMaturityRating(String maturityRating) {
    List<Game> games = gameRepository.findByMaturityRatingLetter(maturityRating);
    return games.stream().map(gameConverter::convertToGameDTO)
        .collect(Collectors.toList());
  }

  //added 04/16/2024 for search by multiplayer/online play
  public List<GameDTO> getGameDTOsByIsCoOp(boolean isCoOp) {
    List<Game> games = gameRepository.findByIsCoOp(isCoOp);
    return games
            .stream()
            .map(gameConverter::convertToGameDTO)
            .collect(Collectors.toList());
  }

  public List<GameDTO> getGameDTOsByIsOnline(boolean isOnline) {
    List<Game> games = gameRepository.findByIsOnline(isOnline);
    return games
            .stream()
            .map(gameConverter::convertToGameDTO)
            .collect(Collectors.toList());
  }

  public Integer getGameIdByGameName(String gameName) {
    Game game = null;
    List<Game> gameList = gameRepository.findByGameName(gameName);
    if(!gameList.isEmpty())
      game = gameList.get(0);

    return game.getId();
  }

  public Game getGameByGameId(Integer gameId) {
    Game game = null;
    Optional<Game> gameList = gameRepository.findById(gameId);
    if(!gameList.isEmpty())
      game = gameList.get();

    return game;
  }
}
