package ui;
import controller.Controller;
import domain.Member;
import domain.MemberShipFee;
import domain.Membership;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ConsoleUI {
    private Controller delfin;

    public ConsoleUI(Controller controller) {
        this.delfin = controller;
    }
    // Note: Menu methods in bottom
    // Program Start //

    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            //String username = menuLogin();
            displayMain();
            }

        }

    // Menu Methods //

    private String menuLogin() {
        IO.println("///Login///");
        IO.println("Input: username password");
        String username = IO.readln(": ");
        IO.println("Login successful \n " +
                "Welcome " + username);
        return username;

    }

    // Main Menu

    private void displayMain() {
        IO.println("///Delphin Admin System///");
        IO.println("1. Members");
        IO.println("2. Finance ");
        IO.println("3. Competition Management");
        IO.println("e. Exit");

        switch(input()){
            case "1" -> displayMember();
            case "2" -> displayFinance();
            case "3" -> displayCompetition();
            case "e" -> exit();
        }

    }

    // Admin Menus //

    private void displayMember() {
        IO.println("///Members");
        IO.println("1. View members");
        IO.println("2. Add member");
        IO.println("3. Edit member");
        IO.println("4. Remove member");
        IO.println("b. Back");
        IO.println("e. Exit");

        switch(input()) {
            case "1" -> viewMembers();
            case "2" -> addMember();
            case "3" -> editMember();
            case "4" -> removeMember();
            case "e" -> exit();
        }
    }

    private void viewMembers() {
        List<Member> members = delfin.getMembers();

        if (members.isEmpty()) {
            IO.println("No current members");
            return;
        }

        IO.println("//Member List//");
        for (Member member : members) {
            IO.println(member.getID() + ", " + member.getName() + ", " + member.getActivityType() + ", " + member.getBirthDate() + "(" + member.getAge() + ")");
        }
    }

    private void addMember() {
        String name;
        int id;
        LocalDate birth;
        Membership activity = Membership.Passive;

        // Name
        name = IO.readln("Name: ");

        // ID
        try {
            id = Integer.parseInt(IO.readln("ID: "));
        } catch (NumberFormatException e) {
            IO.println("Invalid ID — must be a number.");
            return;
        }

        // Birthdate
        try {
            birth = LocalDate.parse(IO.readln("Birthdate: "));
        } catch (DateTimeParseException e) {
            IO.println("Invalid date — Use format yyyy-mm-dd");
            return;
        }

        // Activity
        try {
            String input = IO.readln("Activity (Passive - Exercise - Tournament): ");
            if (!input.isEmpty()) {
                activity = Membership.valueOf(input);
            }
        } catch (IllegalArgumentException e) {
            IO.println("Invalid activity type.");
            return;
        }

        Member member = new Member(name, id, birth, activity);
        delfin.addMember(member);
    }

    private void editMember() {
        IO.println("///Edit Member Activity///");

        int id;
        try {
            id = Integer.parseInt(IO.readln("Member ID: "));
        } catch (NumberFormatException e) {
            IO.println("Invalid ID — must be a number.");
            return;
        }

        Member member = delfin.getMember(id);
        if (member == null) {
            IO.println("No member with ID " + id);
            return;
        }

        IO.println("Member: " + member.getName());
        IO.println("Current activity: " + member.getActivityType());

        Membership activity;
        try {
            activity = Membership.valueOf(IO.readln("New activity (Passive - Exercise - Tournament): "));
        } catch (IllegalArgumentException e) {
            IO.println("Invalid activity type.");
            return;
        }

        delfin.setActivityType(id, activity);
        IO.println("Activity updated to " + activity);
    }

    private void removeMember() {
        IO.println("///Remove Member///");
        int id;

        // ID
        try {
            id = Integer.parseInt(IO.readln("ID: "));
        } catch (NumberFormatException e) {
            IO.println("Invalid ID — must be a number.");
            return;
        }

        Member member = delfin.getMember(id);
        delfin.removeMember(member);
    }

    // Cashier Menus //

    private void displayFinance() {
        boolean inDisplayFinance = true;
        while (inDisplayFinance && isRunning) {
            IO.println("///Finance Menu///");
            IO.println("1. Accounts");
            IO.println("2. Restance List");
            IO.println("3. Reports");
            IO.println("4. Projections");
            IO.println("b. Back");
            IO.println("e. Exit");

            switch (input()) {
                case "1" -> displayAccount();
                case "2" -> displayOverduePayments();
                case "3" -> displayReports();
                case "4" -> displayProjections();
                case "b" -> inDisplayFinance = false;
                case "e" -> isRunning = false;
            }
        }
    }
        private void displayAccount() {
            IO.println("///Accounts///");
            if (delfin.getDuesList().isEmpty()){
                IO.println("List is empty");
            }
            for (MemberShipFee fee : delfin.getDuesList()){
                IO.println(fee);
            }
        }

        private void displayOverduePayments() {
            IO.println("///Overdue Payments///");
            if (delfin.getOverduePayments().isEmpty()){
                IO.println("List is empty");
            }
            for (MemberShipFee overduePayment : delfin.getOverduePayments()){
                IO.println(overduePayment);
            }
        }

        private void displayReports() {
            IO.println("///Reports///");
            IO.println("Total dues paid: " + delfin.totalPaid() + " kr.");
            IO.println("Total dues owed: " + delfin.totalOwed() + " kr.");
        }

        private void displayProjections() {
            IO.println("///Projections///");
            IO.println("Total dues expected: " + delfin.totalExpected() + " kr.");
        }

    // Trainer Menus //

    private void displayCompetition() {
        IO.println("///Competition///");
        IO.println("1. Competitive Teams");
        IO.println("2. View Training Results");
        IO.println("3. Events ");

    }

    private String input() {
        return IO.readln("Input: ").toLowerCase().trim();
    }

    private void exit() {
        IO.println("Terminating Program");
        isRunning = false;
    }
}
