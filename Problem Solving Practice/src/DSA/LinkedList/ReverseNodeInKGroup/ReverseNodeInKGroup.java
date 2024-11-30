package DSA.LinkedList.ReverseNodeInKGroup;

public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        ListNode head = new ListNode(input[0]);
        ListNode node = head;
        for (int i = 1; i < input.length; i++) {
            node.next = new ListNode(input[i]);
            node = node.next;
        }
        printList(head);
        ListNode result = new Solution().reverseKGroup(head, k);
        System.out.println("Result: ");
        printList(result);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0); // Dummy node
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (true) {
            // Step 1: Find the start and end of the current group
            ListNode groupStart = prevGroupTail.next;
            ListNode groupEnd = prevGroupTail;

            for (int i = 0; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            if (groupEnd == null) break; // Fewer than k nodes left, stop

            ListNode nextGroupStart = groupEnd.next; // Save the next group start
            groupEnd.next = null;                    // Temporarily isolate the group

            // Step 2: Reverse the current group
            ListNode reversedGroupHead = reverseList(groupStart);

            // Step 3: Connect groups
            prevGroupTail.next = reversedGroupHead; // Connect previous group to the reversed group
            groupStart.next = nextGroupStart;  // Connect the reversed group to the next group
            prevGroupTail = groupStart;        // Move prevGroupTail to the new group's tail
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}