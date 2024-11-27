package DSA.FastAndSlowPointers.SplitCircularLinkedList;

public class SplitCircularLinkedList {
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

    ListNode[] splitCircularLinkedList(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f.next != head && f.next.next != head) {
            s = s.next;
            f = f.next.next;
        }


        ListNode secondHead = s.next;
        s.next = head;

        ListNode temp = secondHead;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = secondHead;

        return new ListNode[]{head, secondHead};
    }
}