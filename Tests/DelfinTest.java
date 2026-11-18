import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelfinTest {
    private Delfin delfin;
    private Member youthMember;
    private Member seniorMember;
    private Staff staff;

    @BeforeEach
    void setUp(){
        //Arrange
        delfin = new Delfin();

        youthMember = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), ActivityType.Exercise);
        seniorMember = new Member("Biver Andersen", 3,LocalDate.now().minusYears(70), ActivityType.Exercise);
        staff = new Staff("Paul", 1, "password", PrivilegeLevel.ADMINISTRATOR);
    }

    @Test
    void addMember() {
        //Act
        delfin.addMember(youthMember);

        //Assert
        assertEquals(1, delfin.memberList.size());
        assertTrue(delfin.memberList.contains(youthMember));
    }

    @Test
    void addStaff() {
        //Act
        delfin.addStaff(staff);

        //Assert
        assertEquals(1, delfin.staffList.size());
        assertTrue(delfin.staffList.contains(staff));
    }

    @Test
    void removeMember() {
        //Arrange
        delfin.addMember(seniorMember);

        //Act
        delfin.removeMember(seniorMember);

        //Assert
        assertEquals(0, delfin.memberList.size());
        assertFalse(delfin.memberList.contains(seniorMember));
    }

    @Test
    void removeStaff() {
        //Arrange
        delfin.addStaff(staff);

        //Act
        delfin.removeStaff(staff);

        //Assert
        assertEquals(0, delfin.staffList.size());
        assertFalse(delfin.staffList.contains(staff));
    }

    @Test
    void getMember() {
        //Arrange
        delfin.addMember(youthMember);
        int id = youthMember.getID();

        //Act
        delfin.getMember(id);

        //Assert
        assertNotNull(id);
        assertEquals(youthMember.getID(), id);
        assertNull(delfin.getMember(666));

    }

    @Test
    void getMembers() {
    }

    @Test
    void getName() {
    }

    @Test
    void getID() {
    }

    @Test
    void getAge() {
    }

    @Test
    void getActivity() {
    }

    @Test
    void setActivityType() {
    }

    @Test
    void createMemberDues() {
    }

    @Test
    void getDuesList() {
    }

    @Test
    void setFeeDueDate() {
    }

    @Test
    void setFeePaid() {
    }

    @Test
    void totalPaid() {
    }

    @Test
    void totalOwed() {
    }

    @Test
    void getRestance() {
    }
}