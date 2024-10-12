package BigOCoding.Tree.SumOfLeaf;

import java.util.Scanner;

public class SumOfLeaf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        System.out.println(binarySearchTree.sumOfLeaf());
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public void add(int value) {
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.add(value);
            }
        } else if (value > data) {
            if (right == null) {
                right = new Node(value);
            } else {
                right.add(value);
            }
        } else {
            System.out.println("Exist node: " + value);
        }
    }

    public int sumOfLeaf() {
        if (left == null && right == null) {
            return data;
        }
        int leftSum = left == null ? 0 : left.sumOfLeaf();
        int rightSum = right == null ? 0 : right.sumOfLeaf();
        return leftSum + rightSum;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.add(value);
        }
    }

    public int sumOfLeaf() {
        if (root == null) {
            return 0;
        } else {
            return root.sumOfLeaf();
        }
    }
}
