package DSA.LinkedList.ReverseLinkedListII;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 6; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        printList(head);
        ListNode reversedList = new Solution().reverseBetween(head, 1, 3);
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
    // Time complexity: O(n)
    // Space complexity: O(1)

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }

        ListNode orgLeftTail = prev;
        ListNode reversedTail = current;

        for (int i = 0; i <= right - left; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        reversedTail.next = current;
        ListNode reversedHead = prev;

        if (orgLeftTail != null) {
            orgLeftTail.next = reversedHead;
        } else {
            head = reversedHead;
        }
        return head;
    }
}