package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.DeveloperDTO;
import edu.fscj.cen3024c.gamepup.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperConverter {
    public DeveloperDTO convertToDeveloperDTO(Developer developer){
        DeveloperDTO developerDTO = new DeveloperDTO();

        developerDTO.setDeveloperName(developer.getDeveloperName());
        developerDTO.setDeveloperDesc(developer.getDeveloperDesc());

        return developerDTO;
    }

    public Developer convertToDeveloper(DeveloperDTO developerDTO){
        Developer developer = new Developer();

        developer.setDeveloperName(developerDTO.getDeveloperName());
        developer.setDeveloperDesc(developerDTO.getDeveloperDesc());

        return developer;
    }
}
