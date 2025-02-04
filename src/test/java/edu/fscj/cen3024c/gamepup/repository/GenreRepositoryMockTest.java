package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenreRepositoryMockTest {

    @Mock
    private GenreRepository genreRepositoryRepository;


    @Test
    public void testFindById() {
        // Given
        Genre expectedGenre = new Genre();
        expectedGenre.setGenreId(1);
        expectedGenre.setGenreType("RPG");
        expectedGenre.setGenreDescription("Character creation and story driven");
        when(genreRepositoryRepository.findByGenreId(1))
                .thenReturn(Optional.of(expectedGenre));

        // When
        Optional<Genre> actualGenre =
                genreRepositoryRepository.findByGenreId(1);

        // Then
        assertTrue(actualGenre.isPresent(), "Genre should be " +
                "found");
        assertEquals(expectedGenre.getGenreId(),
                actualGenre.get().getGenreId(),
                "Genre id should be " + expectedGenre.getGenreId());
        assertEquals(expectedGenre.getGenreType(),
                actualGenre.get().getGenreType(),
                "Genre name should be " + expectedGenre.getGenreType());
        assertEquals(expectedGenre.getGenreDescription(),
                actualGenre.get().getGenreDescription(),
                "Genre description should be " + expectedGenre.getGenreDescription());

        // Verify methods called
        verify(genreRepositoryRepository).findByGenreId(1);
    }

}