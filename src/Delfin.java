import java.util.List;

public class Delfin {
    private List<Member> memberList;
    private List<Staff> staffList;

    // --- Adders ---
    void addMember(Member member) {
        memberList.add(member);
    }

    void addStaff(Staff staff) {
        staffList.add(staff);
    }

    // --- Removers ---
    void removeMember(Member member) {
        memberList.remove(member);
    }

    void removeStaff(Staff staff) {
        staffList.remove(staff);
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

    public int getAge(Member member) {
        return member.getAge();
    }

    public ActivityType getActivity(Member member) {
        return member.getActivityType();
    }

    // --- Setters ---
    public void setActivityType(int id, ActivityType activityType) {
        Member member = getMember(id);
        member.setActivityType(activityType);
    }
}
