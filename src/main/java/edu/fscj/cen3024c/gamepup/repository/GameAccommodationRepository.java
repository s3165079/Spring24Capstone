package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.GameAccommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameAccommodationRepository extends JpaRepository<GameAccommodation, Integer> {
    //Find by accommodation
    List<GameAccommodation> findByAccommodation(Accommodation accommodation);

    //find by game
    List<GameAccommodation> findByGame(Game game);
}
