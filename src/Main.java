void main() {

    Staff admin = new Staff("Paul", 1, "password", PrivilegeLevel.ADMINISTRATOR);
    Staff cashier = new Staff("Peter", 2, "password", PrivilegeLevel.CASHIER);
    Staff coach = new Staff("Jesus", 3, "password", PrivilegeLevel.TRAINER);

    Delfin delfin = new Delfin();
    UserInterface UI = new UserInterface(delfin);

    // Quick Test Data

    Member member1 = new Member("Anders Andersen", 1,LocalDate.now().minusYears(16), ActivityType.Exercise);
    Member member2 = new Member("Ole Andersen", 2,LocalDate.now().minusYears(19), ActivityType.Exercise);
    Member member3 = new Member("Biver Andersen", 3,LocalDate.now().minusYears(70), ActivityType.Exercise);

    delfin.addMember(member1);
    delfin.addMember(member2);
    delfin.addMember(member3);

    delfin.createMemberDues();
    IO.println(delfin.getDuesList());

    // Program Start

    UI.run();
}