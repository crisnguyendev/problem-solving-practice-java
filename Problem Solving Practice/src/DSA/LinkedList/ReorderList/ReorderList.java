package DSA.LinkedList.ReorderList;

public class ReorderList {
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

    public void reorderList(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if (fastNode != null) {
            slowNode = slowNode.next;
        }
        ListNode reversedNode = reverse(slowNode);
        head = merge(head, reversedNode);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode head = first;
        while (first != null) {
            ListNode temp = first.next;
            first.next = second;
            second = temp;
            first = first.next;
        }
        return head;
    }
}