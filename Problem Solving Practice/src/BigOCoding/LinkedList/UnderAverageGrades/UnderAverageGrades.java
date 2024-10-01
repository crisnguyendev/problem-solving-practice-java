package BigOCoding.LinkedList.UnderAverageGrades;

import java.util.Scanner;

public class UnderAverageGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = new Node(scanner.nextDouble());
        while (scanner.hasNext()) {
            double grade = scanner.nextDouble();
            if (grade == -1)
                break;
            insert(head, grade);
        }
        printUnderAverage(head);
    }

    private static void insert(Node head, double grade) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(grade);
    }

    private static void printUnderAverage(Node head) {
        while (head != null) {
            if (head.grade <= 5.0)
                System.out.println(head.grade + " ");
            head = head.next;
        }
    }

    static class Node {
        double grade;
        Node next;

        public Node(double grade) {
            this.grade = grade;
        }
    }
}
