package DSA.BinarySearchTree.SumValue;

import java.util.Scanner;

public class SumValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 1; i <= n; i++) {
            binarySearchTree.add(scanner.nextInt());
        }
        System.out.println(binarySearchTree.sumValue(x));
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

    public int sumValue(int x) {
        int sum = 0;
        if (data < x) {
            sum += data;
        }
        if (left != null) {
            sum += left.sumValue(x);
        }
        if (right != null) {
            sum += right.sumValue(x);
        }
        return sum;
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

    public int sumValue(int x) {
        if (root == null) {
            return 0;
        } else {
            return root.sumValue(x);
        }
    }

}
