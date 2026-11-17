import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Member> memberList;
    List<Staff> staffList;
    List<Result> resultList;
    public Team(){
        this.memberList = new ArrayList<>();
        this.staffList = new ArrayList<>();
        this.resultList = new ArrayList<>();
    }
    public void addMember(Member memberNew){
        memberList.add(memberNew);
    }
    public void addStaff(Staff staffNew){
        staffList.add(staffNew);
    }
    public void addResult(Result resultNew){
        resultList.add(resultNew);
    }
    public List<Member> seeMembers(){
        return memberList;
    }
    public List<Staff> seeStaff(){
        return staffList;
    }
    public List<Result> seeResults(){
        return resultList;
    }

}
