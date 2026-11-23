package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMemberShipFee {

    @Test
    void testToString (){
        //Arrange
        Member member = new Member("Per", 12, LocalDate.now(), Membership.Passive);
        MemberShipFee fee1 = new MemberShipFee(member, true, 10);
        //Act
        IO.println(fee1);
        //Assert
        assertEquals(fee1.getName(), "Per");
        assertEquals(fee1.getRate(), 500);
        assertEquals(fee1.isPaid(), true);
        assertEquals(fee1.getRestance(), false);
    }

}
