package edu.fscj.cen3024c.gamepup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.fscj.cen3024c.gamepup.entity.Publisher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    //find by id
    Optional<Publisher> findByPublisherId(Integer id);

    //find by publisher name
    List<Publisher> findByPublisherName(String name);
}
