package DSA.TwoPointers.RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(input[0]);
        ListNode temp = head;
        for (int i = 1; i < input.length; i++) {
            temp.next = new ListNode(input[i]);
            temp = temp.next;
        }
        int n = 7;
        ListNode result = new Solution().removeNthFromEnd(head, n);
        System.out.println();
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }
}