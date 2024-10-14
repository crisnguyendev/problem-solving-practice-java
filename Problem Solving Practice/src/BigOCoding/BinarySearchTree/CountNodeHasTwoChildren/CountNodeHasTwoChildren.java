package BigOCoding.BinarySearchTree.CountNodeHasTwoChildren;

import java.util.Scanner;

public class CountNodeHasTwoChildren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        System.out.println(binarySearchTree.countFullNodes());
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
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

    public int countFullNodes() {
        int count = 0;
        if (left != null && right != null) {
            count++;
        }
        if (left != null) {
            count += left.countFullNodes();
        }
        if (right != null) {
            count += right.countFullNodes();
        }
        return count;
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

    public int countFullNodes() {
        if (root == null) {
            return 0;
        } else {
            return root.countFullNodes();
        }
    }
}

