import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Result> tournamentResults = new ArrayList<>();
    private String name;
    private LocalDate date;

    public Tournament(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    //Getters
    public String getName() {
        return name;
    }

    public List<Result> getResultList() {
        return tournamentResults;
    }

    public Result getResult(Member member){
        for (Result result : tournamentResults){
            if (result.getMember() == member){
                return result;
            }
        }
        return null;
    }

    public LocalDate getDate() {
        return date;
    }

    void addResult(Result result){
        tournamentResults.add(result);
    }
}
