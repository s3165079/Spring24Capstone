package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,
         Integer> {

    //find By AccType
    List<Accommodation> findByAccType(String accType);
    //find by AccDesc
    List<Accommodation> findByAccDesc(String accDesc);
    //find by AccId
    Optional<Accommodation> findByAccId(int accId);
}
