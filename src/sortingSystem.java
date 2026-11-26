import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class sortingSystem implements Comparator<Result> {

    final Collator collator = Collator.getInstance(Locale.of("da", "DK"));
    private final String sortBy;

    public sortingSystem(String sortBy) {
        this.sortBy = sortBy.toLowerCase().trim();
    }

    @Override
    public int compare(Result result1, Result result2) {

        int compareTime = Double.compare(result1.getSwimTimeInSeconds(), result2.getSwimTimeInSeconds());
        if (compareTime != 0){
            return compareTime;
        }

        String name1 = result1.getMember().getName();
        String name2 = result2.getMember().getName();
        int compareName = collator.compare(name1, name2);
        if (compareName != 0){
            return compareName;
        }

        String discipline1 = result1.getDiscipline().toString();
        String discipline2 = result2.getDiscipline().toString();
        int compareDiscipline = collator.compare(discipline1, discipline2);
        if (compareDiscipline != 0){
            return compareDiscipline;
        }

        int compareDate = result1.getDate().compareTo(result2.getDate());
        if (compareDate != 0){
            return compareDate;
        }

        String event1 = result1.getEvent();
        String event2 = result2.getEvent();
        return collator.compare(event1, event2);
    }
}
