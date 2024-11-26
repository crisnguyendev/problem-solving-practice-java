package DSA.BinarySearchTree.ListEvenNumber;

import java.util.Scanner;

public class ListEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        binarySearchTree.printEvenNumberPostOrder();
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

    public void printEvenNumberPostOrder() {
        if (left != null) {
            left.printEvenNumberPostOrder();
        }
        if (right != null) {
            right.printEvenNumberPostOrder();
        }
        if (data % 2 == 0) {
            System.out.printf("%d ", data);
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

    public void printEvenNumberPostOrder() {
        if (root != null) {
            root.printEvenNumberPostOrder();
        }
    }
}