package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.DeveloperConverter;
import edu.fscj.cen3024c.gamepup.dto.DeveloperDTO;
import edu.fscj.cen3024c.gamepup.entity.Developer;
import edu.fscj.cen3024c.gamepup.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperConverter developerConverter;

    @Autowired
    public DeveloperService (DeveloperRepository developerRepository,
                             DeveloperConverter developerConverter){
        this.developerRepository = developerRepository;
        this.developerConverter = developerConverter;
    }

    public List<DeveloperDTO> getAllDevelopers() {
        List<Developer> developers = developerRepository.findAll();
        return developers.stream().map(developerConverter::convertToDeveloperDTO)
          .collect(Collectors.toList());
    }

    public List<DeveloperDTO> getDeveloperByName(String developerName) {
        List<Developer> publishers = developerRepository.findByDeveloperName(developerName);
        return publishers.stream().map(developerConverter::convertToDeveloperDTO)
          .collect(Collectors.toList());
    }
}
