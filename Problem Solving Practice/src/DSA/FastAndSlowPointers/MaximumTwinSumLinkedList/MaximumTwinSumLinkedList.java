package DSA.FastAndSlowPointers.MaximumTwinSumLinkedList;

public class MaximumTwinSumLinkedList {

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
    public int pairSum(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode cur = s;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode rev = prev;
        int max = Integer.MIN_VALUE;
        while (rev != null && head != null) {
            max = Math.max(max, rev.val + head.val);
            rev = rev.next;
            head = head.next;
        }
        return max;
    }


}