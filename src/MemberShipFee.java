import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class MemberShipFee {
    private final int age;
    private final String name;
    private final int seniorRate = 1600;
    private final int youthRate = 1000;
    private final int passiveRate = 500;
    private final int rate;
    private final int seniorDiscount = 25;
    private final ActivityType activityType;
    private boolean paid;
    private boolean isOverDue;
    private LocalDate dueDate;

    // David: I made an alternative constructor that only requires 1 argument, and no knowledge of the members values
//    public MemberShipFee(String name, int alder, ActivityType activityType) {
//        this.age = alder;
//        this.activityType = activityType;
//        this.name = name;
//        this.rate = calculateRate();
//    }

    public MemberShipFee(Member member, boolean paid, int dueDateDays) {
        this.age = member.getAge();
        this.activityType = member.getActivityType();
        this.name = member.getName();
        this.rate = calculateRate();
        this.paid = paid;
        // When making an object you can set the due date based on current date +- days, can also test lateness.
        setDueDate(dueDateDays);
        // Calculates if duedate is after current date ONLY if also NOT paid.
        this.isOverDue = isOverDue();
    }


    // Calculates what fee members need to pay based on age and acitivty.
    public int calculateRate(){
        if (activityType == ActivityType.Passive){
            return passiveRate;
        } else if (activityType == ActivityType.Exercise) {
            if (age < 18) {
                return youthRate;
            } else if (age >= 18 && age < 60) {
                return seniorRate;
            } else {
                int discount = seniorRate * seniorDiscount / 100;
                return seniorRate - discount;
            }
        }
        return 0;
    }

    // David: I would argue that this class doesnt need most getters, as this information should be provided by member
    // Getters
    public int getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public boolean isPaid(){
        return paid;
    }

    public boolean getRestance(){
        return isOverDue;
    }

    // Setters

    public void setPaid(Boolean trueFalse){
        paid = trueFalse;
    }

    // dueDate

    // This function can also be used to test restance by giving a negative amount of days making it late.
    public void setDueDate (int CurrentDatePlusDays){
        dueDate = LocalDate.now().plusDays(CurrentDatePlusDays);
    }

    public boolean isOverDue(){
        return (LocalDate.now().isAfter(dueDate) && !paid);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\t Rate: " + rate + "\t Due Date: " + dueDate + "\t Is paid: " + paid + "\t Is overdue: " + isOverDue + "\n";
    }
}
