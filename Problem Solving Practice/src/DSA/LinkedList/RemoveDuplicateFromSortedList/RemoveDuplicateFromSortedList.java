package DSA.LinkedList.RemoveDuplicateFromSortedList;

public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 3, 3, 3, 4};
        int size = input.length;
        ListNode head = new ListNode(input[0]);
        ListNode node = head;
        for (int i = 1; i < size; i++) {
            node.next = new ListNode(input[i]);
            node = node.next;
        }
        printList(head);
        ListNode result = new Solution().deleteDuplicates(head);
        System.out.println("Result: ");
        printList(result);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        int value = current.val;
        ListNode next = current.next;

        while (next != null) {
            if (next.val != value) {
                current.next = next;
                value = next.val;
                current = current.next;
            }
            next = next.next;
        }
        current.next = next;
        return head;
    }
}