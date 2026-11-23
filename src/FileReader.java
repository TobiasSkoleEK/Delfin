import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private Path path;
    private CsvMapper mapper;

    public FileHandler(Path path, CsvMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    // Member save and load
    public void saveMembers(List<Member> memberList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Member member : memberList) {
                String line = mapper.memberToCsv(member);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public List<Member> loadMembers() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Member> members = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                members.add(mapper.csvToMember(line));
            }
            return members;
        }
    }

    // Results
    public void saveResults(List<Result> resultList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Result result : resultList) {
                String line = mapper.resultToCsv(result);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public List<Result> loadResults() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Result> results = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                results.add(mapper.csvToResult(line));
            }
            return results;
        }
    }






}
