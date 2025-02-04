package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    Optional<Developer> findByDeveloperId(Integer id);

    List<Developer> findByDeveloperName(String name);
}
