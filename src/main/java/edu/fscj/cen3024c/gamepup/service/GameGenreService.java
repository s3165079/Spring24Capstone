package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameGenreConverter;
import edu.fscj.cen3024c.gamepup.dto.GameGenreDTO;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.GameGenre;
import edu.fscj.cen3024c.gamepup.entity.Genre;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.GameGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameGenreService {
    private final GameGenreRepository gameGenreRepository;
    private final GameGenreConverter gameGenreConverter;

    @Autowired
    public GameGenreService(GameGenreRepository gameGenreRepository, GameGenreConverter gameGenreConverter) {
        this.gameGenreRepository = gameGenreRepository;
        this.gameGenreConverter = gameGenreConverter;
    }

    @GetMapping
    public List<GameGenreDTO> getAllGameGenreDTOs() {
        List<GameGenre> gameGenres = gameGenreRepository.findAll();
        List<GameGenreDTO> gameGenreDTOs =
                gameGenres.stream().map(gameGenre ->
                        gameGenreConverter.convertToDTO(gameGenre))
                        .collect(Collectors.toList());
        return gameGenreDTOs;
    }

    public List<GameGenreDTO> getGameGenreDTOsByGame(Game game){
        List<GameGenre> gameGenres = gameGenreRepository.findByGame(game);
        List<GameGenreDTO> gameGenreDTOs =
                gameGenres.stream().map(gameGenre ->
                        gameGenreConverter.convertToDTO(gameGenre))
                      .collect(Collectors.toList());
        return gameGenreDTOs;
    }

    public List<GameGenreDTO> getGameGenreDTOsByGenre(Genre genre){
        List<GameGenre> gameGenres = gameGenreRepository.findByGenre(genre);
        List<GameGenreDTO> gameGenreDTOs =
                gameGenres.stream().map(gameGenre ->
                        gameGenreConverter.convertToDTO(gameGenre))
                    .collect(Collectors.toList());
        return gameGenreDTOs;
    }


}
