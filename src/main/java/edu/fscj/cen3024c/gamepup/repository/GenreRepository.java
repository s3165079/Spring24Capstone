package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    // find by genre type
    List<Genre> findByGenreType(String genreType);

    // find by genre description
    List<Genre> findByGenreDesc(String genreDescription);

    // find by genre Id
    Optional<Genre> findByGenreId(int genreId);


}
