package CodeForces.Sorting.StudentSort;

import java.util.Arrays;
import java.util.Scanner;

public class StudentSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            students[i] = new Student(scanner.nextInt(), scanner.nextDouble());
        }
        Arrays.sort(students);
        for (int i = 0; i < k; i++) {
            System.out.println(students[i].getCode());
        }
    }
}

class Student implements Comparable<Student> {
    private final int code;
    private final double grade;

    public Student(int code, double grade) {
        this.code = code;
        this.grade = grade;
    }

    public int getCode() {
        return code;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student student) {
        if (Double.compare(this.grade, student.getGrade()) == 0)
            return Integer.compare(this.code, student.getCode());
        return Double.compare(student.getGrade(), this.grade);
    }

}
