package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.GenreConverter;
import edu.fscj.cen3024c.gamepup.dto.GenreDTO;
import edu.fscj.cen3024c.gamepup.entity.Genre;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    @Autowired
    public GenreService(GenreRepository genreRepository, GenreConverter genreConverter) {
        this.genreRepository = genreRepository;
        this.genreConverter = genreConverter;
    }

    public List<GenreDTO> getAllGenreDTOs(){
        List<Genre> genres = genreRepository.findAll();
        List<GenreDTO> genreDTOs = genres.stream().map(genre ->
                genreConverter.convertToDTO(genre))
                .collect(Collectors.toList());
        return genreDTOs;
    }

    public List<GenreDTO> getGenreByType(String genreType) {
        List<Genre> genres = genreRepository.findByGenreType(genreType);
        List<GenreDTO> genreDTOs = genres.stream().map(genre ->
                genreConverter.convertToDTO(genre))
              .collect(Collectors.toList());
        return genreDTOs;
    }

    public List<GenreDTO> getGenreByDescription(String genreDescription) {
        List<Genre> genres = genreRepository.findByGenreDesc(genreDescription);
        List<GenreDTO> genreDTOs = genres.stream().map(genre ->
                genreConverter.convertToDTO(genre))
            .collect(Collectors.toList());
        return genreDTOs;
    }

    public GenreDTO getGenreByGenreId(int genreId) {
        Genre genre = genreRepository.findByGenreId(genreId)
             .orElseThrow(() ->new ResourceNotFoundException(
                        String.format("Genre with id %d not found", genreId)));
        return genreConverter.convertToDTO(genre);
    }
}
