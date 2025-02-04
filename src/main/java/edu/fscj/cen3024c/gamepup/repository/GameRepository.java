package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    //find by id
    Optional<Game> findById(Integer id);

    //find by game name
    List<Game> findByGameName(String gameName);

    //find by release date
    List<Game> findByReleaseDate(LocalDateTime releaseDate);

    //find by maturity rating
    List<Game> findByMaturityRatingLetter(String rating);

    //added 04/16/2024 for search by multiplayer/online play
    //find by co-op status
    List<Game> findByIsCoOp(boolean isCoOp);

    //find by online multiplayer status
    List<Game> findByIsOnline(boolean isOnline);

    //added 04/16/2024 for search by low play time and high rating
    //find by play time
    List<Game> findByPlayTime(Integer playTime);
}
