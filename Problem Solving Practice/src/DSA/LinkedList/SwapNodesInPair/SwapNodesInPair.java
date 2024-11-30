package DSA.LinkedList.SwapNodesInPair;

public class SwapNodesInPair {
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        int k = 2;
        while (true) {
            ListNode groupStart = prevGroupTail.next;
            ListNode groupEnd = prevGroupTail;
            for (int i = 0; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            if (groupEnd == null)
                break;
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;

            ListNode reversedGroup = reverse(groupStart);

            prevGroupTail.next = reversedGroup;
            groupStart.next = nextGroupStart;

            prevGroupTail = groupStart;

        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverse = head;
        ListNode prev = null;
        while (reverse != null) {
            ListNode temp = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = temp;
        }
        return prev;
    }
}

class OptimalSolution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = first;
        }
        return dummy.next;
    }
}