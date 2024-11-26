package DSA.LinkedList.PrimeNumbersInLinkedList;

import java.util.Scanner;

public class PrimeNumbersInLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node node = new Node(scanner.nextInt());
        Node head = node;
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            Node newNode = new Node(value);
            node.next = newNode;
            node = newNode;
        }
        System.out.println(countPrime(head));
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countPrime(Node head) {
        int count = 0;
        while (head != null) {
            if (isPrime(head.value))
                count++;
            head = head.next;
        }
        return count;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
