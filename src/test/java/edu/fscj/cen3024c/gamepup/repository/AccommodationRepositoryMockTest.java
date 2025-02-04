package edu.fscj.cen3024c.gamepup.repository;

import edu.fscj.cen3024c.gamepup.entity.Accommodation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import edu.fscj.cen3024c.gamepup.repository.AccommodationRepository;

@ExtendWith(MockitoExtension.class)
public class AccommodationRepositoryMockTest {

    @Mock
    private AccommodationRepository accommodationRepository;

    @Test
    public void testFindById() {
        // Given
        Accommodation expectedAccommodation = new Accommodation();
        expectedAccommodation.setAccId(1);
        expectedAccommodation.setAccType("Subtitles");
        expectedAccommodation.setAccDesc("Displays sound as text");
        when(accommodationRepository.findByAccId(1))
                .thenReturn(Optional.of(expectedAccommodation));

        // When
        // mocked repo object
        Optional<Accommodation> actualAccommodation =
                accommodationRepository.findByAccId(1);

        // Then
        assertTrue(actualAccommodation.isPresent(), "Accommodation should be " +
                "found");
        assertEquals(expectedAccommodation.getAccId(),
                actualAccommodation.get().getAccId(),
                "Accommodation id should be " + expectedAccommodation.getAccId());
        assertEquals(expectedAccommodation.getAccType(),
                actualAccommodation.get().getAccType(),
                "Accommodation type should be " + expectedAccommodation.getAccType());
        assertEquals(expectedAccommodation.getAccDesc(),
                actualAccommodation.get().getAccDesc(),
                "Accommodation description should be " + expectedAccommodation.getAccDesc());

        // Verify methods called
        verify(accommodationRepository).findByAccId(1);
    }

}
