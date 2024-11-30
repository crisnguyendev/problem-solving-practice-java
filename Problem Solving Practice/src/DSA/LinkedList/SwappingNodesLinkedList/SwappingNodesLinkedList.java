package DSA.LinkedList.SwappingNodesLinkedList;

public class SwappingNodesLinkedList {
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        ListNode left = current;
        current = current.next;
        ListNode right = head;
        while (current != null) {
            current = current.next;
            right = right.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}