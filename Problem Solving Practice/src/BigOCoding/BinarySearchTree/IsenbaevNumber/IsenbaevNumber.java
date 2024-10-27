package BigOCoding.BinarySearchTree.IsenbaevNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsenbaevNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTeams = scanner.nextInt();
        List<List<String>> teamates = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            teamates.add(new ArrayList<>());
        }
        for (int i = 0; i < totalTeams; i++) {
            String member1 = scanner.next();
            String member2 = scanner.next();
            String member3 = scanner.next();
        }
    }
}

class Member{
    String name;
}