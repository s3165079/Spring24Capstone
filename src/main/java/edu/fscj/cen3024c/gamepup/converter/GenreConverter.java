package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.GenreDTO;
import edu.fscj.cen3024c.gamepup.entity.Genre;
import org.springframework.stereotype.Component;


@Component
public class GenreConverter {

    public GenreDTO convertToDTO(Genre genre){
        GenreDTO dto = new GenreDTO();
        dto.setGenreId(genre.getGenreId());
        dto.setGenreType(genre.getGenreType());
        dto.setGenreDescription(genre.getGenreDescription());
        return dto;
    }

    public Genre convertToEntity(GenreDTO dto){
        Genre entity = new Genre();
        entity.setGenreId(dto.getGenreId());
        entity.setGenreType(dto.getGenreType());
        entity.setGenreDescription(dto.getGenreDescription());
        return entity;
    }
}
