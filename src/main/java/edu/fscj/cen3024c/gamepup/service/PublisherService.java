package edu.fscj.cen3024c.gamepup.service;

import edu.fscj.cen3024c.gamepup.converter.PublisherConverter;
import edu.fscj.cen3024c.gamepup.dto.PublisherDTO;
import edu.fscj.cen3024c.gamepup.entity.Publisher;
import edu.fscj.cen3024c.gamepup.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherConverter publisherConverter;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository,
                            PublisherConverter publisherConverter){
        this.publisherRepository = publisherRepository;
        this.publisherConverter = publisherConverter;
    }

    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream().map(publisherConverter::convertToPublisherDTO)
          .collect(Collectors.toList());
    }

    public List<PublisherDTO> getPublisherByName(String publisherName) {
        List<Publisher> publishers = publisherRepository.findByPublisherName(publisherName);
        return publishers.stream().map(publisherConverter::convertToPublisherDTO)
          .collect(Collectors.toList());
    }
}
