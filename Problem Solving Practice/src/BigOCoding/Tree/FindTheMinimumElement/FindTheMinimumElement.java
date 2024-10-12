package BigOCoding.Tree.FindTheMinimumElement;

import java.util.Scanner;

public class FindTheMinimumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        System.out.println(binarySearchTree.getMin());
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public void add(int x) {
        if (x < data) {
            if (left == null) {
                left = new Node(x);

            } else {
                left.add(x);
            }
        } else if (x > data) {
            if (right == null) {
                right = new Node(x);
            } else {
                right.add(x);
            }
        } else {
            System.out.println("Exist node: " + x);
        }
    }

    public int getMin() {
        if (left == null) {
            return data;
        }
        return left.getMin();
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            root.add(x);
        }
    }

    public int getMin() {
        return root.getMin();
    }
}
