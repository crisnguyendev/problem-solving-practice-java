package DSA.LinkedList.ReverseNodesEvenLengthGroup;

public class ReverseNodesEvenLengthGroup {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(input[0]);
        ListNode node = head;
        for (int i = 1; i < input.length; i++) {
            node.next = new ListNode(input[i]);
            node = node.next;
        }
        printList(head);
        ListNode reversedList = new Solution().reverseEvenLengthGroups(head);
        System.out.println("Reversed List: ");
        printList(reversedList);
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        ListNode prevGroupTail = null;
        int groupSize = 1;

        while (current != null) {
            ListNode groupStart = current;
            ListNode groupEnd = current;
            int count = 1;

            // Step 1: Find the end of the group
            while (count < groupSize && groupEnd.next != null) {
                groupEnd = groupEnd.next;
                count++;
            }

            // Step 2: Temporarily disconnect the group from the rest
            ListNode nextGroupStart = groupEnd.next; // Save the next group's start
            groupEnd.next = null;                   // Disconnect the current group

            // Step 3: Reverse the group if its length is even
            if (count % 2 == 0) {

                // Link the previous group to the reversed group
                prevGroupTail.next = reverse(groupStart);
                // Update the tail of the reversed group to point to the next group
                groupStart.next = nextGroupStart;
                // Update prevGroupTail to the current group's original start (now its tail)
                prevGroupTail = groupStart;
            } else {
                // If the group is not reversed, reconnect it as-is
                if (prevGroupTail != null) {
                    prevGroupTail.next = groupStart;
                }
                prevGroupTail = groupEnd; // Update prevGroupTail to the group's end
            }

            // Step 4: Move to the next group and increment the group size
            current = nextGroupStart;
            groupSize++;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) { // Reverse until the end of the disconnected group
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev; // Return the new head of the reversed group
    }
}
