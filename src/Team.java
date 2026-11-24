import java.util.ArrayList;
import java.util.List;

public class Team {
    int id;
    List<Member> memberList;
    List<Staff> staffList; // Has a staffList because you can have 1 or more coaches on a team
//    List<Result> resultList; // removable
    public Team(int id) {
        this.id = id;
        this.memberList = new ArrayList<>();
        this.staffList = new ArrayList<>();
//        this.resultList = new ArrayList<>();
    }

    //Adders
    public void addMember(Member member) {
        memberList.add(member);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void removeMember(Member member) {
        memberList.remove(member);
    }

//    public void addResult(Result result) {
//        resultList.add(result);
    //}

    //Getters
    public int getId() {
        return id;
    }

    public Member getMember(int id) {
        for (Member member : memberList) {
            if (member.getID() == id) {
                return member;
            }
        }
        return null;
    }

    public Staff getStaff(int id) {
        for (Staff staff : staffList) {
            if (staff.getID() == id) {
                return staff;
            }
        }
        return null;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

//    public List<Result> getResultList() {
//        return resultList;
//    }

}
