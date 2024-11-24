package CodeForces.Abstraction.ExcellentStudent;

import java.util.Scanner;

public class ExcellentStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            double mathScore = scanner.nextDouble();
            double writingScore = scanner.nextDouble();
            Student student = new Student(name, mathScore, writingScore);
            if (student.getGPA() >= 9.0)
                count++;
        }
        System.out.println(count);
    }
}

class Student {
    private final String name;
    private final double mathScore;
    private final double writingScore;

    public Student(String name, double mathScore, double writingScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.writingScore = writingScore;
    }

    public double getGPA() {
        return (mathScore + writingScore) / 2;
    }
}
