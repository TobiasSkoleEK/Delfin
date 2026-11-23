import controller.Controller;
import domain.*;
import ui.ConsoleUI;

void main() {

    Staff admin = new Staff("Paul", 1, "password", PrivilegeLevel.Administrator);
    Staff cashier = new Staff("Peter", 2, "password", PrivilegeLevel.Cashier);
    Staff coach = new Staff("Jesus", 3, "password", PrivilegeLevel.Trainer);

    Controller delfin = new Controller();
    ConsoleUI UI = new ConsoleUI(delfin);

    // Quick Test Data

    Member member1 = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), Membership.Exercise);
    Member member2 = new domain.Member("Ole Andersen", 2,LocalDate.now().minusYears(19), Membership.Exercise);
    Member member3 = new domain.Member("Biver Andersen", 3,LocalDate.now().minusYears(70), Membership.Exercise);

    delfin.addMember(member1);
    delfin.addMember(member2);
    delfin.addMember(member3);

    delfin.createMemberDues();
    // Quick test data for finance
    MemberShipFee fee = delfin.getDuesList().get(0);
    delfin.setFeeDueDate(fee, -14);
    delfin.setFeePaid(fee, false);
    //-------------------------------------------------
    IO.println(delfin.getDuesList());

    // Program Start

    UI.run();
}