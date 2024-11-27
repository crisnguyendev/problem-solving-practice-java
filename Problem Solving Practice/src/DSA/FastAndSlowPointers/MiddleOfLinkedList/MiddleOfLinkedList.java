package DSA.FastAndSlowPointers.MiddleOfLinkedList;

public class MiddleOfLinkedList {
    public static void main(String args[]) {

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

    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}