package DSA.KWayMerge.MergeKSortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedList {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        ListNode[] lists = new ListNode[5];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});
        lists[3] = createList(new int[]{0, 9});
        lists[4] = createList(new int[]{6, 8});

        // Run the mergeKLists method
        ListNode result = solution.mergeKLists(lists);

        // Print the result
        printList(result);
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0)
            return null;
        if (k == 1)
            return lists[0];
        int interval = 1;
        while (interval < k) {
            for (int i = 0; i < k - interval; i += interval * 2) {
                lists[i] = mergeLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        if (head1 != null) {
            head.next = head1;
        }
        if (head2 != null) {
            head.next = head2;
        }
        return dummy.next;
    }
}