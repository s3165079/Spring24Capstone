package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.GenreDTO;
import edu.fscj.cen3024c.gamepup.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genresService;

    @Autowired
    public GenreController(GenreService genresService) {
        this.genresService = genresService;
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenreDTOs() {
        List<GenreDTO> genreDTOs = genresService.getAllGenreDTOs();
        return ResponseEntity.ok().body(genreDTOs);
    }

    @GetMapping("/bytype/{genreType}")
    public ResponseEntity<List<GenreDTO>> getGenreByType(
            @PathVariable(value = "genreType") String genreType) {
        List<GenreDTO> genreDTOs = genresService.getGenreByType(genreType);
        return ResponseEntity.ok().body(genreDTOs);
    }

    @GetMapping("/bydescription/{genreDescription}")
    public ResponseEntity<List<GenreDTO>> getGenreByDescription(
            @PathVariable(value = "genreDescription") String genreDescription) {
        List<GenreDTO> genreDTOs = genresService
                .getGenreByDescription(genreDescription);
        return ResponseEntity.ok().body(genreDTOs);
    }

    @GetMapping("/bygenreId/{genreId}")
    public ResponseEntity<GenreDTO> getGenreByGenreId(
            @PathVariable(value = "genreId") int genreId) {
        GenreDTO genreDTO = genresService.getGenreByGenreId(genreId);
        return ResponseEntity.ok().body(genreDTO);
    }
}
