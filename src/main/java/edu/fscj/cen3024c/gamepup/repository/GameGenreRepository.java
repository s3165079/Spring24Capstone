package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Game;
import edu.fscj.cen3024c.gamepup.entity.GameGenre;
import edu.fscj.cen3024c.gamepup.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameGenreRepository extends JpaRepository<GameGenre, Integer> {
    //Find by Game
    List<GameGenre> findByGame(Game game);

    //Find by Genre
    List<GameGenre> findByGenre(Genre genre);
}
