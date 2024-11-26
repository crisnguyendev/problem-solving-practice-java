package DSA.LinkedList.EndingWithFive;

import java.util.Scanner;

public class EndingWithFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(scanner.nextInt());
            if (head == null) {
                tail = newNode;
                head = tail;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        Node removedHead = removeEndingWithFive(head);
        print(removedHead);
    }

    private static Node removeEndingWithFive(Node head) {
        while (head != null && Math.abs(head.value) % 10 == 5) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        Node previous = head;
        while (previous != null && previous.next != null) {
            if (Math.abs(previous.next.value) % 10 == 5) {
                previous.next = previous.next.next;
            }
            previous = previous.next;
        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
