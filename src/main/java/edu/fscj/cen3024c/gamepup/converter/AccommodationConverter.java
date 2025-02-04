package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.dto.AccommodationDTO;
import org.springframework.stereotype.Component;


@Component
public class AccommodationConverter {

    public AccommodationDTO convertToDTO(Accommodation entity){
        AccommodationDTO dto = new AccommodationDTO();

        dto.setAccId(entity.getAccId());
        dto.setAccType(entity.getAccType());
        dto.setAccDesc(entity.getAccDesc());

        return dto;
    }

    public Accommodation convertToEntity(AccommodationDTO dto){
        Accommodation entity = new Accommodation();

        entity.setAccId(dto.getAccId());
        entity.setAccType(dto.getAccType());
        entity.setAccDesc(dto.getAccDesc());

        return entity;
    }
}
