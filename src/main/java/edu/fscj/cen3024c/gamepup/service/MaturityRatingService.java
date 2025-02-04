package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.MaturityRatingConverter;
import edu.fscj.cen3024c.gamepup.dto.MaturityRatingDTO;
import edu.fscj.cen3024c.gamepup.entity.MaturityRating;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.MaturityRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaturityRatingService {
    private final MaturityRatingRepository maturityRatingRepository;
    private final MaturityRatingConverter maturityRatingConverter;

    @Autowired
    public MaturityRatingService(MaturityRatingRepository maturityRatingRepository,
                                 MaturityRatingConverter maturityRatingConverter){
        this.maturityRatingRepository = maturityRatingRepository;
        this.maturityRatingConverter = maturityRatingConverter;
    }

    public List<MaturityRatingDTO> getAllMaturityRatingDTOs() {
        List<MaturityRating> maturityRatings =  maturityRatingRepository.findAll();
        return maturityRatings.stream().map(maturityRatingConverter::convertToMaturityRatingDTO)
          .collect(Collectors.toList());
    }

    public MaturityRatingDTO getMaturityRatingDTOByLetter(String letter){
        MaturityRating maturityRating = maturityRatingRepository.findByLetter(letter)
          .orElseThrow(() -> new ResourceNotFoundException(
            "Maturity rating not found with letter: " + letter
          ));

        return maturityRatingConverter.convertToMaturityRatingDTO(maturityRating);
    }

    public List<MaturityRatingDTO> getMaturityRatingsByMinAge(Integer age){
        List<MaturityRating> maturityRating = maturityRatingRepository.findByMinAge(age);
        return maturityRating.stream().map(maturityRatingConverter::convertToMaturityRatingDTO)
          .collect(Collectors.toList());
    }
}
