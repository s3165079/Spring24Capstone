package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.AccommodationConverter;
import edu.fscj.cen3024c.gamepup.dto.AccommodationDTO;
import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.exceptions.ResourceNotFoundException;
import edu.fscj.cen3024c.gamepup.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationConverter accommodationConverter;

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository, AccommodationConverter accommodationConverter) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationConverter = accommodationConverter;
    }

    public List<AccommodationDTO> getAllAccommodationDTOs(){
        List<Accommodation> accommodations = accommodationRepository.findAll();
        List<AccommodationDTO> accommodationDTOs =
                accommodations.stream().map(accommodation ->
                        accommodationConverter.convertToDTO(accommodation))
                        .collect(Collectors.toList());
        return accommodationDTOs;
    }

    public List<AccommodationDTO> getAccommodationByType(String accType){
        List<Accommodation> accommodations = accommodationRepository
                .findByAccType(accType);
        List<AccommodationDTO> accommodationDTOS =
                accommodations.stream().map(accommodation ->
                        accommodationConverter.convertToDTO(accommodation))
                        .collect(Collectors.toList());
        return accommodationDTOS;
    }

    public List<AccommodationDTO> getAccommodationByDescription(String accDesc){
        List<Accommodation> accommodations = accommodationRepository
               .findByAccDesc(accDesc);
        List<AccommodationDTO> accommodationDTOS =
                accommodations.stream().map(accommodation ->
                        accommodationConverter.convertToDTO(accommodation))
                       .collect(Collectors.toList());
        return accommodationDTOS;
    }

    public AccommodationDTO getAccommodationById(int accId){
        Accommodation accommodation = accommodationRepository.findByAccId(accId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(
                        "Accommodation with id %d not found", accId)));
        return accommodationConverter.convertToDTO(accommodation);
    }
}
