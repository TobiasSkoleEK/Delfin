import domain.Member;
import domain.Membership;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMemberClass {

    Member member1 = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), Membership.Exercise);
    Member member2 = new Member("Ole Andersen", 2,LocalDate.now().minusYears(19), Membership.Exercise);
    Member member3 = new Member("Biver Andersen", 3,LocalDate.now().minusYears(70), Membership.Exercise);


    @Test
    void testMemberAttributes(){
        // Displays ToString
        IO.println(member1);
        // Checks Getters
        assertEquals(member1.getName(),"Anders Andersen");
        assertEquals(member1.getID(), 1);
        assertEquals(member1.getAge(), 16); // This also tests the method Age calculation.
        assertEquals(member1.getActivityType(), Membership.Exercise);

    }

    @Test
    void testMemberSetActivity(){
        //
        member1.setActivityType(Membership.Passive);
        //
        assertEquals(member1.getActivityType(), Membership.Passive);
    }
}
