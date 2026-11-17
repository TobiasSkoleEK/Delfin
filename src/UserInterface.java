public class UserInterface {
    private Delfin delfin = new Delfin();
    // Note: Menu methods in bottom
    // Program Start //

    public void run(){
        boolean isRunning = true;
        while (isRunning) {
            String username = menuLogin();
            displayMain();
            isRunning = false;
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
            case "e" -> IO.println("Terminating Program");
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

    }

    // Cashier Menus //

    private void displayFinance() {
        IO.println("///Finance Menu///");
        IO.println("1. Accounts");
        IO.println("2. Restance List");
        IO.println("3. Reports");
        IO.println("4. Projections");
        IO.println("b. Back");
        IO.println("e. Exit");

        String display = IO.readln("Input Command: ").trim().toLowerCase();

        switch (display){
            case "1." -> displayAccount();
            case "2." -> displayRestanceList();
            case "3." -> displayReports();
            case "4." -> displayProjections();
        }
    }
        private void displayAccount(){
            IO.println("///Accounts///");
            if (delfin.getDuesList().isEmpty()){
                IO.println("List is empty");
            }
            for (MemberShipFee feeList : delfin.getDuesList()){
                IO.println(feeList);
            }
        }

        private void displayRestanceList(){
            IO.println("///Restance///");
            if (delfin.getRestance().isEmpty()){
                IO.println("List is empty");
            }
            for (MemberShipFee restanceList : delfin.getRestance()){
                IO.println(restanceList);
            }
        }

        private void displayReports(){
            IO.println("///Reports///");
            IO.println("Total dues paid: " + delfin.totalPaid() + " kr.");
            IO.println("Total dues owed: " + delfin.totalOwed() + " kr.");
        }

        private void displayProjections(){
            IO.println("///Projections///");
            IO.println("Total dues expected: " + delfin.totalPaid() + " kr.");
        }



    // Trainer Menus //

    private void displayCompetition() {
        IO.println("///Competition///");
        IO.println("1. Competitive Teams");
        IO.println("2. View Training Results");
        IO.println("3. Events ");

    }

    private String input(){
        return IO.readln("Input: ").toLowerCase().trim();
    }


}
