package DSA.FastAndSlowPointers.SplitCircularLinkedList;

public class SplitCircularLinkedList {
}

class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode() {
    }

    LinkedListNode(int val) {
        this.val = val;
    }

    LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static LinkedListNode[] splitCircularLinkedList(LinkedListNode head) {
        LinkedListNode s = head;
        LinkedListNode f = head;

        while (f.next != head && f.next.next != head) {
            s = s.next;
            f = f.next.next;
        }


        LinkedListNode secondHead = s.next;
        s.next = head;

        LinkedListNode temp = secondHead;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = secondHead;

        return new LinkedListNode[]{head, secondHead};
    }
}