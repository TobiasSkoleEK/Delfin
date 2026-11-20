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
        //Arrange
        delfin.addMember(youthMember);
        delfin.addMember(seniorMember);

        //Act
        List<Member> members = delfin.getMembers();

        //Assert
        assertEquals(2, members.size());
        assertTrue(members.containsAll(List.of(youthMember, seniorMember)));
    }

    @Test
    void getName() {
        //Assert
        assertEquals("Anders Andersen", youthMember.getName());
        assertNotNull(youthMember.getName());
    }

    @Test
    void getID() {
        //Assert
        assertEquals(1, youthMember.getID());
        assertNotNull(youthMember.getID());
    }

    @Test
    void getAge() {
        //Assert
        assertEquals(16, youthMember.getAge());
        assertNotNull(youthMember.getAge());
    }

    @Test
    void getActivity() {
        //Assert
        assertEquals(ActivityType.Exercise, delfin.getActivity(youthMember));
    }

    @Test
    void setActivityType() {
        //Arrange
        delfin.addMember(youthMember);
        int id = youthMember.getID();

        //act
        delfin.setActivityType(id, ActivityType.Passive);

        //Assert
        assertEquals(ActivityType.Passive, youthMember.getActivityType());
        assertNotNull(youthMember.getActivityType());
    }

    @Test
    void createMemberDues() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.addMember(youthMember);

        //Act
        delfin.createMemberDues();

        //Assert
        assertEquals(2, delfin.getDuesList().size());
    }

    @Test
    void getDuesList() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.createMemberDues();

        //Act
        List<MemberShipFee> dues = delfin.getDuesList();

        //Assert
        assertEquals(1, dues.size());
        assertNotNull(dues);
    }

    @Test
    void setFeeDueDate() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.createMemberDues();
        MemberShipFee fee = delfin.getDuesList().get(0);

        //Act
        delfin.setFeeDueDate(fee, -7);
        delfin.setFeePaid(fee, false);

        //Assert
        assertTrue(fee.isOverDue());
        assertFalse(fee.isPaid());
    }

    @Test
    void setFeePaid() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.createMemberDues();
        MemberShipFee fee = delfin.getDuesList().get(0);

        //Act
        delfin.setFeePaid(fee, false);

        //Assert
        assertFalse(fee.isPaid());
    }

    @Test
    void totalPaid() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.addMember(youthMember);
        delfin.createMemberDues();

        //Act
        int totalAmount = 0;
        for (MemberShipFee fee : delfin.getDuesList()){
            totalAmount += fee.getRate();
        }

        //Arrange
        assertEquals(totalAmount, delfin.totalPaid());
    }

    @Test
    void totalOwed() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.addMember(youthMember);
        delfin.createMemberDues();
        MemberShipFee fee = delfin.getDuesList().get(0);

        //Act
        delfin.setFeeDueDate(fee, -7);
        delfin.setFeePaid(fee, false);

        //Arrange
        assertEquals(fee.getRate(), delfin.totalOwed());
        assertTrue(fee.isOverDue());
    }

    @Test
    void getRestance() {
        //Arrange
        delfin.addMember(seniorMember);
        delfin.addMember(youthMember);
        delfin.createMemberDues();
        MemberShipFee fee = delfin.getDuesList().get(0);

        //Act
        delfin.setFeeDueDate(fee, -7);
        delfin.setFeePaid(fee, false);
        List<MemberShipFee> restance = delfin.getRestance();

        //Assert
        assertEquals(1, restance.size());
        assertTrue(restance.contains(fee));
        assertFalse(fee.isPaid());
    }
}