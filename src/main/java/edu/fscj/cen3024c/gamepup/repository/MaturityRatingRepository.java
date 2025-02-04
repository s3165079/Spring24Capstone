package edu.fscj.cen3024c.gamepup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.fscj.cen3024c.gamepup.entity.MaturityRating;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MaturityRatingRepository extends JpaRepository<MaturityRating, Integer> {
    Optional<MaturityRating> findByLetter(String letter);
    List<MaturityRating> findByMinAge(Integer age);

}
