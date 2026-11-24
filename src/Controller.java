import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    List<Member> memberList = new ArrayList<Member>();
    List<Staff> staffList = new ArrayList<Staff>();
    List<MemberShipFee> duesList = new ArrayList<MemberShipFee>();
    List<Team> teamList = new ArrayList<Team>();

    // --- Admin ---
    // Adders
    void addMember(Member member) {
        memberList.add(member);
    }

    void addStaff(Staff staff) {
        staffList.add(staff);
    }

    void addTeams(int... teamIds) {
        for (int id : teamIds) {
            teamList.add(findTeam(id));
        }
    }

    // Removers
    void removeMember(Member member) {
        memberList.remove(member);
    }

    void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    // Getters
    public List<Member> getMembers() {
        return memberList;
    }

    public String getName(Member member) {
        return member.getName();
    }

    public int getID(Member member) {
        return member.getID();
    }

    public LocalDate getBirthDate(Member member) {
        return member.getBirthDate();
    }

    public int getAge(Member member) {
        return member.getAge();
    }

    public Membership getMembership(Member member) {
        return member.getMembership();
    }

    // Setters
    public boolean setMembership(int id, Membership membership) {
        Member member = findMember(id);
        if (member == null) {
            return false;
        }
        member.setMembership(membership);
        return true;
    }

    // Finders
    public Member findMember(int ID) {
        for (Member member : memberList) {
            if (member.getID() == ID) {
                return member;
            }
        }
        return null;
    }

    // --- Cashier Commands ---

    // Adders
    //Clears dueList and recreates it based on member list, currently everything is paid and overdue is false
    public void createMemberDues() {
        duesList.clear();
        for (Member member : memberList) {
            duesList.add(new MemberShipFee(member, true, 0));
        }
    }

    // Getters
    //Returns the list of dues
    public List<MemberShipFee> getDuesList() {
        return duesList;
    }

    //This functions creates a new list based on the duesList condition isOveDue, then returns only those
    //where it is true giving a list of those who are late.
    public List<MemberShipFee> getOverduePayments() {
        return duesList.stream().filter(MemberShipFee::isOverDue).toList();
    }

    //This functions creates a new list based on the duesList condition isPaid, then returns only those
    //where it is true giving a list of those who have not paid.
    public List<MemberShipFee> getPaid() {
        return duesList.stream().filter(MemberShipFee::isPaid).toList();
    }

    // Setters
    //Cashier can extend dueDates or shorten them for testing
    public void setFeeDueDate(MemberShipFee member, int Days) {
        member.setDueDate(Days);
    }

    //Cashier can change a members status to paid once paid.
    public void setFeePaid(MemberShipFee member, boolean trueFalse) {
        member.setPaid(trueFalse);
    }

    // Functions
    //Function to show total amount of expected dues
    public int totalPaid() {
        int total = 0;
        for (MemberShipFee fee : getPaid()) {
            total += fee.getRate();
        }
        return total;
    }

    //Function to show total amount unpaid dues
    public int totalOwed() {
        int total = 0;
        for (MemberShipFee fee : getOverduePayments()) {
            total += fee.getRate();
        }
        return total;
    }

    //Function to show totalOwed + totalPaid
    public int totalExpected() {
        return totalPaid() + totalOwed();
    }

    // --- Trainer ---
    Team unassigned = new Team(0);
    Team JuniorCrawl = new Team(1);
    Team JuniorBackcrawl = new Team(2);
    Team JuniorButterfly = new Team(3);
    Team JuniorBreaststroke = new Team(4);
    Team SeniorCrawl = new Team(5);
    Team SeniorBackcrawl = new Team(6);
    Team SeniorButterfly = new Team(7);
    Team SeniorBreaststroke = new Team(8);

    // Adders
    public void addTeamMember(Team team, Member member) {
        team.addMember(member);
    }

    // Getters
    public List<Team> getTeamList() {
        return teamList;
    }

    // Finders
    public Team findTeam(int id) {
        for (Team team : teamList) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    public int findMemberId(String name) {
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                return member.getID();
            }
        }
        throw new IllegalArgumentException("Member not found: " + name);
    }

    // Functions
    public void moveTeamMember(int memberID, Team destinationTeam) {
        Member memberToMove = findMember(memberID);
        Team originTeam = findTeam(memberToMove.getID());
        destinationTeam.addMember(memberToMove);
        originTeam.removeMember(memberToMove);
    }
}
