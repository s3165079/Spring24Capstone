package edu.fscj.cen3024c.gamepup.controller;

import edu.fscj.cen3024c.gamepup.dto.PublisherDTO;
import edu.fscj.cen3024c.gamepup.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers(){
        List<PublisherDTO> publisherDTOs = publisherService.getAllPublishers();
        return ResponseEntity.ok(publisherDTOs);
    }

    @GetMapping("/{publisherName}")
    public ResponseEntity<List<PublisherDTO>> getPublisherByPublisherName(
      @PathVariable("publisherName") String publisherName){
        List<PublisherDTO> publisherDTOs = publisherService.getPublisherByName(publisherName);
        return ResponseEntity.ok(publisherDTOs);
    }
}
