package BigOCoding.BinarySearchTree.PrintIncrementally;

import java.util.Scanner;

public class PrintIncrementally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        binarySearchTree.printInOrder();
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

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.printf("%d ", data);
        if (right != null) {
            right.printInOrder();
        }
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

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }
}
