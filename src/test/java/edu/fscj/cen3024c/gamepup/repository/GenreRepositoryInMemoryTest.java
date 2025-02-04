package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Genre;
import edu.fscj.cen3024c.gamepup.repository.GenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GenreRepositoryInMemoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void createGenre_ShouldReturnNewGenre(){
        // Given
        Genre newGenre = new Genre();
        newGenre.setGenreId(1);
        newGenre.setGenreType("RPG");
        newGenre.setGenreDescription("Character creation and story driven");

        // When
        Genre savedGenre =
                genreRepository.save(newGenre);

        // Then
        Genre foundGenre =
                entityManager.find(Genre.class,
                        savedGenre.getGenreId());

        assertThat(foundGenre).isEqualTo(savedGenre);
    }

}
