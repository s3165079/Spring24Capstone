package edu.fscj.cen3024c.gamepup.converter;

import edu.fscj.cen3024c.gamepup.dto.PublisherDTO;
import edu.fscj.cen3024c.gamepup.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverter {

    public PublisherDTO convertToPublisherDTO(Publisher publisher){
        PublisherDTO publisherDTO = new PublisherDTO();

        publisherDTO.setPublisherName(publisher.getPublisherName());
        publisherDTO.setPublisherDesc(publisher.getPublisherDesc());

        return publisherDTO;
    }

    public Publisher convertToPublisher(PublisherDTO publisherDTO){
        Publisher publisher = new Publisher();

        publisher.setPublisherName(publisherDTO.getPublisherName());
        publisher.setPublisherDesc(publisherDTO.getPublisherDesc());

        return publisher;
    }
}
