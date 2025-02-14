package fr.epita.assistants.streamstudent;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Streamer {

    // Validator: Remove invalid students based on grade and login format
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(pair -> {
            int grade = pair.getKey();
            String login = pair.getValue();
            if(grade < 0 || grade > 100){
                return false;
            }
            long underscoreCount = login.chars().filter(ch -> ch == '_').count();
            long dotCount = login.chars().filter(ch -> ch=='.').count();

            return (underscoreCount == 1 && dotCount == 0) || (underscoreCount==0 && dotCount==1);
        });
    }

    // Order students by grade, and by login lexicographically if grades are the same
    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted((p1,p2)->{
            int gradeComparison = Integer.compare(p1.getKey(), p2.getKey());
            return (gradeComparison !=0 ) ? gradeComparison : p1.getValue().compareTo(p2.getValue());
        });
    }

    // Convert logins to lowercase and halve the grade if it contained uppercase letters
    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            String login = pair.getValue();
            int grade = pair.getKey();
            if (!login.equals(login.toLowerCase())) {
                grade /= 2;
            }
            return new Pair<>(grade, login.toLowerCase());
        });
    }

    // Return the student with the highest grade, lowest login if tie
    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.max(Comparator.comparing((Pair<Integer,String>pair)->pair.getKey()));
    }

    // Double the grades for students whose login starts with "ma" or "l" and ends with "x"
    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            int grade = pair.getKey();
            String login = pair.getValue();
            if (login.toLowerCase().startsWith("ma") ||
                    (login.toLowerCase().startsWith("l") && login.toLowerCase().endsWith("x"))) {
                grade = Math.min(100, grade * 2);
            }
            return new Pair<>(grade, login);
        });
    }

    // Encrypt logins using the split-inverse-merge method
    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            String login = pair.getValue();
            int grade = pair.getKey();
            int mid = login.length() / 2;
            String first = login.substring(0,mid);
            String second = login.substring(mid);

            String encrypted = second + first;
            return new Pair<>(grade, encrypted);
        });
    }
}
