package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.GameAccommodationDTO;
import edu.fscj.cen3024c.gamepup.entity.GameAccommodation;
import org.springframework.stereotype.Component;


@Component
public class GameAccommodationConverter {
    public GameAccommodationDTO convertToDTO(GameAccommodation entity) {
        GameAccommodationDTO dto = new GameAccommodationDTO();

        dto.setAccommodation(entity.getAccommodation());
        dto.setGame(entity.getGame());

        return dto;
    }

    public GameAccommodation convertToEntity(GameAccommodationDTO dto) {
        GameAccommodation entity = new GameAccommodation();

        entity.setAccommodation(dto.getAccommodation());
        entity.setGame(dto.getGame());

        return entity;
    }
}
