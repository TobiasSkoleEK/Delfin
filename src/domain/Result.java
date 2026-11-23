package domain;

import java.time.LocalDate;

public class Result {

    final private Member swimmer;
    final private SwimDisciplines discipline;
    final private String event;
    final private double swimTimeInSeconds;
    final private boolean isTournament;
    final private LocalDate date;

    // for training results set isTournament to FALSE.
    public Result (String event,
                   Member swimmer,
                   double time,
                   SwimDisciplines discipline,
                   boolean isTournament,
                   LocalDate date){
        this.event = event;
        this.swimmer = swimmer;
        this.swimTimeInSeconds = time;
        this.discipline = discipline;
        this.isTournament = isTournament;
        this.date = date;


    }

    // Getters


    public double getSwimTimeInSeconds() {
        return swimTimeInSeconds;
    }

    public Member getSwimmer() {
        return swimmer;
    }

    public String getEvent() {
        return event;
    }

    public SwimDisciplines getDiscipline() {
        return discipline;
    }

    public boolean isTournament() {
        return isTournament;
    }

    // To String - boolean not included in toString, if training event event name should be "Training"

    @Override
    public String toString() {
        return "\t Event: " + getEvent()
                + "\t Name: " + swimmer.getName()
                + "\t Time in Seconds: " + getSwimTimeInSeconds()
                + "\t Discipline: " + getDiscipline();

    }
}
