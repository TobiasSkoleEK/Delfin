public class MembershipFee {
    private final int age;
    private final String name;
    private final int seniorRate = 1600;
    private final int youthRate = 1000;
    private final int passiveRate = 500;
    private final int rate;
    private final int seniorDiscount = 25;
    private final ActivityType activityType;

    public MembershipFee(String name, int alder, ActivityType activityType) {
        this.age = alder;
        this.activityType = activityType;
        this.name = name;
        this.rate = calculateRate();
    }

    // Calculates what fee members need to pay based on age and acitivty.
    public int calculateRate(){
        if (activityType == ActivityType.Passive){
            return passiveRate;
        }
        if (activityType == ActivityType.Exercise) {
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
}
