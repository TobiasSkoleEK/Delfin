import domain.Member;
import domain.Membership;
import domain.Result;
import domain.SwimDisciplines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResultTest {

    private Member swimmer;
    private LocalDate testDate;

    @BeforeEach
    void setUp() {
        //Arrange
        testDate = LocalDate.of(2026, 11, 23);
        swimmer = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), Membership.Exercise);
    }

    @Test
    void getSwimTimeInSeconds() {
        //Arrange
        Result result = new Result("Club Championship", swimmer, 55.30, SwimDisciplines.Crawl, true, testDate);

        //Assert
        assertEquals(55.30, result.getSwimTimeInSeconds());
    }

    @Test
    void getSwimmer() {
        //Arrange
        Result result = new Result("Club Championship", swimmer, 55.30, SwimDisciplines.Crawl, true, testDate);

        //Assert
        assertNotNull(result.getSwimmer());
        assertEquals("Anders Andersen", result.getSwimmer().getName());
        assertEquals(1, result.getSwimmer().getID());

    }

    @Test
    void getEvent() {

    }

    @Test
    void getDiscipline() {
    }

    @Test
    void isTournament() {
    }

    @Test
    void testToString() {
    }
}