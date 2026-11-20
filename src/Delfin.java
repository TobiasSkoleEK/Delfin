import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Delfin {
    List<Member> memberList = new ArrayList<Member>();
    List<Staff> staffList = new ArrayList<Staff>();
    List<MemberShipFee> duesList = new ArrayList<MemberShipFee>();
    List<Team> teamList = new ArrayList<Team>();

    // --- Adders ---
    void addMember(Member member) {
        memberList.add(member);
    }

    void addStaff(Staff staff) {
        staffList.add(staff);
    }

    void addTeam(Team team) {
        teamList.add(team);
    }

    void addTeamMember(Team team, Member member) {
        team.addMember(member);
    }

    // --- Removers ---
    void removeMember(Member member) {
        memberList.remove(member);
    }

    void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    void removeTeam(Team team) {
        teamList.remove(team);
    }

    // --- Getters ---
    public Member getMember(int ID) {
        for (Member member : memberList) {
            if (member.getID() == ID) {
                return member;
            }
        } return null;
    }

    public List<Member> getMembers() {
        return memberList;
    }

    public String getName(Member member) {
        return  member.getName();
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

    public ActivityType getActivity(Member member) {
        return member.getActivityType();
    }

    public Team getTeam(int id) {
        for (Team team : teamList) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }


    // --- Setters ---
    public boolean setActivityType(int id, ActivityType activityType) {
        Member member = getMember(id);
        if (member == null) {
            return false;
        }
        member.setActivityType(activityType);
        return true;
    }

    // --- Cashier Commands ---

    // Clears due list and recreates it based on member list, currently everything is paid and overdue is false
    public void createMemberDues(){
        duesList.clear();
        for (Member member: memberList){
            duesList.add(new MemberShipFee(member, true, 0));
        }
    }

    //Returns the list of dues
    public List<MemberShipFee> getDuesList() {
        return duesList;
    }

    //Cashier can extent dueDates or shorten them for testing
    public void setFeeDueDate (MemberShipFee member, int Days){
        member.setDueDate(Days);
    }

    //Cashier can change a members status to paid once paid.
    public void setFeePaid (MemberShipFee member, boolean trueFalse){
        member.setPaid(trueFalse);
    }

    //Function to show total amount of expected dues
    public int totalPaid(){
        int total = 0;
        for (MemberShipFee fee: getPaid()){
            total += fee.getRate();
        }
        return total;
    }

    //Function to show total amount unpaid dues
    public int totalOwed(){
        int total = 0;
        for (MemberShipFee fee: getRestance()){
            total += fee.getRate();
        }
        return total;
    }
    
    //Function to show totalOwed + totalPaid
    public int totalExpected(){
        return totalPaid() + totalOwed();
    }

    // This functions creates a new list based on the duesList condition isOveDue, then returns only those
    // where it is true giving a list of those who are late.
    public List<MemberShipFee> getRestance() {
        return duesList.stream().filter(MemberShipFee::isOverDue).toList();
    }

    // This functions creates a new list based on the duesList condition isPaid, then returns only those
    // where it is true giving a list of those who have not paid.
    public List<MemberShipFee> getPaid() {
        return duesList.stream().filter(MemberShipFee::isPaid).toList();
    }


}
