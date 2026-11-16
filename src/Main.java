void main() {

    Staff admin = new Staff("Paul", 1, "password", PrivilegeLevel.ADMINISTRATOR);
    Staff cashier = new Staff("Peter", 2, "password", PrivilegeLevel.CASHIER);
    Staff coach = new Staff("Jesus", 3, "password", PrivilegeLevel.TRAINER);

    UserInterface UI = new UserInterface();
    UI.run();
}