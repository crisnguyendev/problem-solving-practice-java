package CodeForces.BinarySearchTree.DistinctCount;

import java.util.Scanner;

public class DistinctCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            int N = scanner.nextInt();
            int X = scanner.nextInt();
            for (int j = 0; j < N; j++) {
                binarySearchTree.add(scanner.nextInt());
            }
            int nodeCount = binarySearchTree.countNodes();
            if (nodeCount == X) {
                System.out.println("Good");
            } else if (nodeCount > X) {
                System.out.println("Average");
            } else {
                System.out.println("Bad");
            }
        }
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
        }
    }

    public int countNodes() {
        int leftNodes = left == null ? 0 : left.countNodes();
        int rightNodes = right == null ? 0 : right.countNodes();
        return leftNodes + rightNodes + 1;
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

    public int countNodes() {
        if (root == null) {
            return 0;
        } else  {
            return root.countNodes();
        }
    }
}
