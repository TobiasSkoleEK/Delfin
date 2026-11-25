import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;
    private Member youthMember;
    private Member seniorMember;
    private Staff staff;
    private Team team;

    @BeforeEach
    void setUp(){
        //Arrange
        controller = new Controller();

        youthMember = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), Membership.Exercise);
        seniorMember = new Member("Biver Andersen", 3,LocalDate.now().minusYears(70), Membership.Exercise);
        staff = new Staff("Paul", 1, "password", PrivilegeLevel.Administrator);
        team = new Team(1);
    }

    @Test
    void addMember() {
        //Act
        controller.addMember(youthMember);

        //Assert
        assertEquals(1, controller.memberList.size());
        assertTrue(controller.memberList.contains(youthMember));
    }

    @Test
    void addStaff() {
        //Act
        controller.addStaff(staff);

        //Assert
        assertEquals(1, controller.staffList.size());
        assertTrue(controller.staffList.contains(staff));
    }

    @Test
    void removeMember() {
        //Arrange
        controller.addMember(seniorMember);

        //Act
        controller.removeMember(seniorMember);

        //Assert
        assertEquals(0, controller.memberList.size());
        assertFalse(controller.memberList.contains(seniorMember));
    }

    @Test
    void removeStaff() {
        //Arrange
        controller.addStaff(staff);

        //Act
        controller.removeStaff(staff);

        //Assert
        assertEquals(0, controller.staffList.size());
        assertFalse(controller.staffList.contains(staff));
    }

    @Test
    void getMember() {
        //Arrange
        controller.addMember(youthMember);
        int id = youthMember.getID();

        //Act
        controller.findMember(id);

        //Assert
        assertNotNull(id);
        assertEquals(youthMember.getID(), id);
        assertNull(controller.findMember(666));

    }

    @Test
    void getMembers() {
        //Arrange
        controller.addMember(youthMember);
        controller.addMember(seniorMember);

        //Act
        List<Member> members = controller.getMembers();

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
    void getMembership() {
        //Assert
        assertEquals(Membership.Exercise, controller.getMembership(youthMember));
    }

    @Test
    void setMembership() {
        //Arrange
        controller.addMember(youthMember);
        int id = youthMember.getID();

        //act
        controller.setMembership(id, Membership.Passive);

        //Assert
        assertEquals(Membership.Passive, youthMember.getMembership());
        assertNotNull(youthMember.getMembership());
    }

    @Test
    void createMemberDues() {
        //Arrange
        controller.addMember(seniorMember);
        controller.addMember(youthMember);

        //Act
        controller.createMemberDues();

        //Assert
        assertEquals(2, controller.getDuesList().size());
    }

    @Test
    void getDuesList() {
        //Arrange
        controller.addMember(seniorMember);
        controller.createMemberDues();

        //Act
        List<MemberShipFee> dues = controller.getDuesList();

        //Assert
        assertEquals(1, dues.size());
        assertNotNull(dues);
    }

    @Test
    void setFeeDueDate() {
        //Arrange
        controller.addMember(seniorMember);
        controller.createMemberDues();
        MemberShipFee fee = controller.getDuesList().get(0);

        //Act
        controller.setFeeDueDate(fee, -7);
        controller.setFeePaid(fee, false);

        //Assert
        assertTrue(fee.isOverDue());
        assertFalse(fee.isPaid());
    }

    @Test
    void setFeePaid() {
        //Arrange
        controller.addMember(seniorMember);
        controller.createMemberDues();
        MemberShipFee fee = controller.getDuesList().get(0);

        //Act
        controller.setFeePaid(fee, false);

        //Assert
        assertFalse(fee.isPaid());
    }

    @Test
    void totalPaid() {
        //Arrange
        controller.addMember(seniorMember);
        controller.addMember(youthMember);
        controller.createMemberDues();

        //Act
        int totalAmount = 0;
        for (MemberShipFee fee : controller.getDuesList()){
            totalAmount += fee.getRate();
        }

        //Arrange
        assertEquals(totalAmount, controller.totalPaid());
    }

    @Test
    void totalOwed() {
        //Arrange
        controller.addMember(seniorMember);
        controller.addMember(youthMember);
        controller.createMemberDues();
        MemberShipFee fee = controller.getDuesList().get(0);

        //Act
        controller.setFeeDueDate(fee, -7);
        controller.setFeePaid(fee, false);

        //Arrange
        assertEquals(fee.getRate(), controller.totalOwed());
        assertTrue(fee.isOverDue());
    }

    @Test
    void getRestance() {
        //Arrange
        controller.addMember(seniorMember);
        controller.addMember(youthMember);
        controller.createMemberDues();
        MemberShipFee fee = controller.getDuesList().get(0);

        //Act
        controller.setFeeDueDate(fee, -7);
        controller.setFeePaid(fee, false);
        List<MemberShipFee> restance = controller.getOverduePayments();

        //Assert
        assertEquals(1, restance.size());
        assertTrue(restance.contains(fee));
        assertFalse(fee.isPaid());
    }

    @Test
    void addTeamMember(){
        //Arrange
        controller.addTeamMember(team, seniorMember);

        //Assert
        assertEquals(1, team.getMemberList().size());
        assertTrue(team.memberList.contains(seniorMember));
    }

}