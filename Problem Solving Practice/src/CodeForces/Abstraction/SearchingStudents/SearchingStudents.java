package CodeForces.Abstraction.SearchingStudents;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchingStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Map<String, StudentScore> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            double mathScore = scanner.nextDouble();
            double literatureScore = scanner.nextDouble();
            StudentScore studentScore = new StudentScore(mathScore, literatureScore);
            map.put(id, studentScore);
        }

        for (int i = 0; i < q; i++) {
            String searchQuery = scanner.next();
            if (map.containsKey(searchQuery)) {
                StudentScore studentScore = map.get(searchQuery);
                System.out.println(studentScore);
            }
        }
    }
}

class StudentScore {
    private final double mathScore;
    private final double literatureScore;

    public StudentScore(double mathScore, double literatureScore) {
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
    }

    @Override
    public String toString() {
        return mathScore + " " + literatureScore;
    }
}

