package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.MaturityRatingDTO;
import edu.fscj.cen3024c.gamepup.entity.MaturityRating;
import org.springframework.stereotype.Component;

@Component
public class MaturityRatingConverter {

    //MaturityRating to MaturityRatingDTO
    public MaturityRatingDTO convertToMaturityRatingDTO(MaturityRating maturityRating){
        MaturityRatingDTO maturityRatingDTO = new MaturityRatingDTO();

        maturityRatingDTO.setMinAge(maturityRating.getMinAge());
        maturityRatingDTO.setLetter(maturityRating.getLetter());
        maturityRatingDTO.setDesc(maturityRating.getDesc());

        return maturityRatingDTO;
    }

    public MaturityRating convertToMaturityRating(MaturityRatingDTO maturityRatingDTO){
        MaturityRating maturityRating = new MaturityRating();

        maturityRating.setMinAge(maturityRatingDTO.getMinAge());
        maturityRating.setLetter(maturityRatingDTO.getLetter());
        maturityRating.setDesc(maturityRatingDTO.getLetter());

        return maturityRating;
    }
}
