package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.DeveloperDTO;
import edu.fscj.cen3024c.gamepup.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService){
        this.developerService = developerService;
    }

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> getAllDevelopers(){
        List<DeveloperDTO> developerDTOs = developerService.getAllDevelopers();
        return ResponseEntity.ok(developerDTOs);
    }

    @GetMapping("/{developerName}")
    public ResponseEntity<List<DeveloperDTO>> getDeveloperByDeveloperName(
      @PathVariable("developerName") String developerName){
        List<DeveloperDTO> developerDTOs = developerService.getDeveloperByName(developerName);
        return ResponseEntity.ok(developerDTOs);
    }
}
