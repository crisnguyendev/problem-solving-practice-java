package DSA.FastAndSlowPointers.PalindromeLinkedList;

public class PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode reverseHalf = prev;
        while (reverseHalf != null) {
            if (reverseHalf.val != head.val) {
                return false;
            }
            reverseHalf = reverseHalf.next;
            head = head.next;
        }
        return true;
    }
}