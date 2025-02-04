package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GameAccommodationConverter;
import edu.fscj.cen3024c.gamepup.dto.GameAccommodationDTO;
import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.GameAccommodation;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.GameAccommodationRepository;
import edu.fscj.cen3024c.gamepup.repository.GameGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameAccommodationService {
    private final GameAccommodationRepository gameAccommodationRepository;
    private final GameAccommodationConverter gameAccommodationConverter;

    @Autowired
    public GameAccommodationService(
            GameAccommodationRepository gameAccommodationRepository,
            GameAccommodationConverter gameAccommodationConverter) {
        this.gameAccommodationRepository = gameAccommodationRepository;
        this.gameAccommodationConverter = gameAccommodationConverter;
    }

    public List<GameAccommodationDTO> getAllGameAccommodationDTOs() {
        List<GameAccommodation> gameAccommodations =
                gameAccommodationRepository.findAll();
        List<GameAccommodationDTO> gameAccommodationDTOS =
                gameAccommodations.stream().map(gameAccommodation ->
                        gameAccommodationConverter.convertToDTO(gameAccommodation))
                        .collect(Collectors.toList());
        return gameAccommodationDTOS;
    }

    public List<GameAccommodationDTO> getGameAccommodationByGame(Game game){
        List<GameAccommodation> gameAccommodations =
                gameAccommodationRepository.findByGame(game);
        List<GameAccommodationDTO> gameAccommodationDTOS =
                gameAccommodations.stream().map(gameAccommodation ->
                        gameAccommodationConverter.convertToDTO(gameAccommodation))
                      .collect(Collectors.toList());
        return gameAccommodationDTOS;
    }

    public List<GameAccommodationDTO> getGameAccommodationByAccommodation(
            Accommodation accommodation){
        List<GameAccommodation> gameAccommodations =
                gameAccommodationRepository.findByAccommodation(accommodation);
        List<GameAccommodationDTO> gameAccommodationDTOS =
                gameAccommodations.stream().map(gameAccommodation ->
                        gameAccommodationConverter.convertToDTO(gameAccommodation))
                        .collect(Collectors.toList());
        return gameAccommodationDTOS;
    }


}
