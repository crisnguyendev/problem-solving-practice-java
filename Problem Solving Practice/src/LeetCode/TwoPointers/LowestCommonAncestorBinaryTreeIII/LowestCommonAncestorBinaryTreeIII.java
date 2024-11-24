package LeetCode.TwoPointers.LowestCommonAncestorBinaryTreeIII;

public class LowestCommonAncestorBinaryTreeIII {
}


class EduTreeNode {
    int data;
    EduTreeNode left;
    EduTreeNode right;
    EduTreeNode parent;

    EduTreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class Solution {
    public EduTreeNode LowestCommonAncestor(EduTreeNode p, EduTreeNode q) {
        EduTreeNode p1 = p;
        EduTreeNode p2 = q;
        while (p1 != p2) {
            if (p1.parent != null) {
                p1 = p1.parent;
            } else {
                p1 = q;
            }

            if(p2.parent != null) {
                p2 = p2.parent;
            } else {
                p2 = p;
            }
        }
        return p1;
    }
}
