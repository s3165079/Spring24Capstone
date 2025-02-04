package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.AccommodationDTO;
import edu.fscj.cen3024c.gamepup.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationDTO>> getAllAccommodationDTOs(){
        List<AccommodationDTO> accommodationDTOs = accommodationService
                .getAllAccommodationDTOs();
        return ResponseEntity.ok().body(accommodationDTOs);
    }

    @GetMapping("/bytype/{accType}")
    public ResponseEntity<List<AccommodationDTO>> getAccommodationByType(
            @PathVariable(value = "accType") String accType){
        List<AccommodationDTO> accommodationDTOs = accommodationService
             .getAccommodationByType(accType);
        return ResponseEntity.ok().body(accommodationDTOs);
    }

    @GetMapping("/byDescription/{accDescription}")
    public ResponseEntity<List<AccommodationDTO>> getAccommodationByDescription(
            @PathVariable(value = "accDescription") String accDescription){
        List<AccommodationDTO> accommodationDTOs = accommodationService
           .getAccommodationByDescription(accDescription);
        return ResponseEntity.ok().body(accommodationDTOs);
    }
}

