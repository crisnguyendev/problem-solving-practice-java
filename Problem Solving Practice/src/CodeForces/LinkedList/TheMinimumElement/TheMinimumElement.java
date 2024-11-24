package CodeForces.LinkedList.TheMinimumElement;

import java.util.Scanner;

public class TheMinimumElement {
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
        System.out.println(findMinimum(head));
    }

    private static int findMinimum(Node head) {
        int min = Integer.MAX_VALUE;
        while (head != null) {
            min = Math.min(min, head.value);
            head = head.next;
        }
        return min;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}


