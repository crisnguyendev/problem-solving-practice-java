package BigOCoding.BinarySearchTree.MonkAndFriends;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MonkAndFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();

        for (int i = 0; i < totalTestCases; i++) {
            int currentStudents = scanner.nextInt();
            int comingStudents = scanner.nextInt();
            Set<Long> set = new TreeSet<>();
            for (int j = 0; j < currentStudents; j++) {
                set.add(scanner.nextLong());
            }
            for (int j = 0; j < comingStudents; j++) {
                long newStudent = scanner.nextLong();
                if (set.contains(newStudent)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                    set.add(newStudent);
                }
            }
        }
    }
}
