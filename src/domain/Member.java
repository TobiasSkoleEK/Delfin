package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    String name;
    final int ID;
    final LocalDate birthDate;
    Membership membership;

    public Member(String name, int ID, LocalDate birthDate, Membership membership) {
        this.name = name;
        this.ID = ID;
        this.birthDate = birthDate;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = (int) ChronoUnit.YEARS.between(birthDate, today);
        return age;
    }

    public int getID() {
        return ID;
    }

    public Membership getActivityType() {
        return membership;
    }

    public void setActivityType(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "\t Name: " + getName()
                + "\t ID: " + getID()
                + "\t Age: " + getAge()
                + "\t Activity: " + getActivityType() + "\n";
    }
}
