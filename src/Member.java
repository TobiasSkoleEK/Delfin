import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    String name;
    final int ID;
    final LocalDate birthDate;
    ActivityType activityType;

    public Member(String name, int ID, LocalDate birthDate, ActivityType activityType) {
        this.name = name;
        this.ID = ID;
        this.birthDate = birthDate;
        this.activityType = activityType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = (int) ChronoUnit.YEARS.between(birthDate, today);
        return age;
    }

    public int getID() {
        return ID;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
