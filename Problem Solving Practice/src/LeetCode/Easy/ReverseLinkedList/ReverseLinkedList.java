package LeetCode.Easy.ReverseLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        printList(head);
        ListNode reversedList = new Solution().reverseList(head);
        System.out.println("Reversed List: ");
        printList(reversedList);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}