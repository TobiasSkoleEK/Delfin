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
        return 0;
    }
}
