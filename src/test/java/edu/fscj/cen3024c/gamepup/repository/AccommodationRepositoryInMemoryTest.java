package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import edu.fscj.cen3024c.gamepup.repository.AccommodationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccommodationRepositoryInMemoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    public void createAccommodation_ShouldReturnNewAccommodation(){
        // Given
        Accommodation newAccommodation = new Accommodation();
        newAccommodation.setAccId(1);
        newAccommodation.setAccType("Subtitles");
        newAccommodation.setAccDesc("Displays sound as text");

        // When
        Accommodation savedAccommodation =
                accommodationRepository.save(newAccommodation);

        // Then
        Accommodation foundAccommodation =
                entityManager.find(Accommodation.class,
                        savedAccommodation.getAccId());

        assertThat(foundAccommodation).isEqualTo(savedAccommodation);
    }

}
