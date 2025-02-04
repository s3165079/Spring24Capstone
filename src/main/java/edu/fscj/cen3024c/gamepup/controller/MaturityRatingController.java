package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.MaturityRatingDTO;
import edu.fscj.cen3024c.gamepup.service.MaturityRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maturityRatings")
public class MaturityRatingController {
    private final MaturityRatingService maturityRatingService;

    @Autowired
    public MaturityRatingController(MaturityRatingService maturityRatingService){
        this.maturityRatingService = maturityRatingService;
    }

    @GetMapping
    public ResponseEntity<List<MaturityRatingDTO>> getAllMaturityRatings() {
        List<MaturityRatingDTO> maturityRatingDTOs = maturityRatingService.getAllMaturityRatingDTOs();
        return ResponseEntity.ok(maturityRatingDTOs);
    }

    @GetMapping("/{letter}")
    public ResponseEntity<MaturityRatingDTO> getMaturityRatingByLetter(
      @PathVariable("letter") String letter){
        MaturityRatingDTO maturityRatingDTO = maturityRatingService.getMaturityRatingDTOByLetter(letter);
        return ResponseEntity.ok(maturityRatingDTO);
    }

    @GetMapping("/{minAge}")
    public ResponseEntity<List<MaturityRatingDTO>> getMaturityRatingByMinAge(
      @PathVariable("minAge") Integer minAge){
        List<MaturityRatingDTO> maturityRatingDTOs = maturityRatingService.getMaturityRatingsByMinAge(minAge);
        return ResponseEntity.ok(maturityRatingDTOs);
    }
}
