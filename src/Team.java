import java.util.ArrayList;
import java.util.List;

public class Team {
    int id;
    List<Member> memberList;
    List<Staff> staffList;
    List<Result> resultList;
    public Team(int id) {
        this.id = id;
        this.memberList = new ArrayList<>();
        this.staffList = new ArrayList<>();
        this.resultList = new ArrayList<>();
    }

    //Adders
    public void addMember(Member memberNew){
        memberList.add(memberNew);
    }

    public void addStaff(Staff staffNew){
        staffList.add(staffNew);
    }

    public void addResult(Result resultNew){
        resultList.add(resultNew);
    }

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

    public List<Member> getMemberList(){
        return memberList;
    }

    public List<Staff> getStaffList(){
        return staffList;
    }

    public List<Result> getResultList(){
        return resultList;
    }

}
