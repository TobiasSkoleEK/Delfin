import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Result> resultList = new ArrayList<>();
    private String name;
    private LocalDate date;
    private List<Competitor> participantList = new ArrayList<>();

    public Tournament(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    //Getters
    public String getName() {
        return name;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public LocalDate getDate() {
        return date;
    }

    void addResult(Result result){
        resultList.add(result);
    }
}
