package DSA.TwoPointers.LowestCommonAncestorBinaryTreeIII;

public class LowestCommonAncestorBinaryTreeIII {
}


class Node {
    int val;
    Node left;
    Node right;
    Node parent;

    Node(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class Solution {
    // Time complexity: O(h) - h: height of tree
    // Space complexity: O(1)

    public Node lowestCommonAncestor(Node p, Node q) {
        Node temp1 = p, temp2 = q;
        while(temp1 != temp2) {
            temp1 = temp1 != null ? temp1.parent: q;
            temp2 = temp2 != null ? temp2.parent: p;
        }
        return temp1;
    }
}
