package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.GameGenreDTO;
import edu.fscj.cen3024c.gamepup.entity.GameGenre;
import org.springframework.stereotype.Component;


@Component
public class GameGenreConverter {
    public GameGenreDTO convertToDTO(GameGenre entity) {
        GameGenreDTO dto = new GameGenreDTO();

        dto.setGame(entity.getGame());
        dto.setGenre(entity.getGenre());

        return dto;
    }

    public GameGenre convertToEntity(GameGenreDTO dto) {
        GameGenre entity = new GameGenre();

        entity.setGame(dto.getGame());
        entity.setGenre(dto.getGenre());

        return entity;
    }
}
