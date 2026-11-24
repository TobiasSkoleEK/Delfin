import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CSVMapper {

    private String delimiter = ",";

    // Members
    public Member csvToMember(String line) {
        String[] tokens = line.split(delimiter, -1);
        String name = tokens[0];
        int id = Integer.parseInt(tokens[1]);
        LocalDate birthdate = LocalDate.parse(tokens[2]);
        Membership membership = switch(tokens[3]) {
            case "Exercise" -> Membership.Exercise;
            case "Passive" -> Membership.Passive;
            case "Tournament" -> Membership.Tournament;
            default -> throw new IllegalArgumentException(
                    "Unknown membership: " + tokens[3]);
        };

        return new Member(name, id, birthdate, membership);
    }

    public String memberToCsv(Member member) {
        return member.getName()
                + delimiter + member.getID()
                + delimiter + member.getAge()
                + delimiter + member.getMembership();
    }

    // Results
    public Result csvToResult(String line, List<Member> memberList) {
        String[] tokens = line.split(delimiter, -1);
        String event = tokens[0];
        String memberName = tokens[2];

        Member member = findMember(memberName, memberList);

        SwimDisciplines dis = switch(tokens[1]) {
            case "Backcrawl" -> SwimDisciplines.Backcrawl;
            case "Crawl" -> SwimDisciplines.Crawl;
            case "Breaststroke" -> SwimDisciplines.Breaststroke;
            case "Butterfly" -> SwimDisciplines.Butterfly;
            default -> throw new IllegalArgumentException(
                    "Unknown membership: " + tokens[1]);};


        double swimtime = Double.parseDouble(tokens[3]);
        boolean isTournament = Boolean.parseBoolean(tokens[4]);
        LocalDate date = LocalDate.parse(tokens[5]);

        return new Result(event, member, swimtime, dis, isTournament, date);
    }

    public String resultToCsv(Result result) {
        return result.getEvent()
                + delimiter + result.getMember().getName()
                + delimiter + result.getSwimTimeInSeconds()
                + delimiter + result.getDiscipline()
                + delimiter + result.isTournament()
                + delimiter + result.getDate();
    }

    private Member findMember(String name, List<Member> memberList) {
        for (Member member : memberList) {
            if (Objects.equals(member.getName(), name)) {
                return member;
            }
        }
        return null;
    }
}
