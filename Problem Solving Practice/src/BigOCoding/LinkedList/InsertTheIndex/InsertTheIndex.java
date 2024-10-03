package BigOCoding.LinkedList.InsertTheIndex;

import java.util.Scanner;

public class InsertTheIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 1;
        Node current = null;
        Node head = null;
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value == 0)
                break;
            Node newNode = new Node(index);
            if (head == null) {
                current = newNode;
                head = current;
            } else {
                current.next = newNode;
                current = current.next;
            }
            current.next = new Node(value);
            current = current.next;
            index++;
        }
        printList(head);
    }

    private static void printList(Node head) {
        while (true) {
            System.out.print(head.value);
            head = head.next;
            if (head == null)
                break;
            else
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
