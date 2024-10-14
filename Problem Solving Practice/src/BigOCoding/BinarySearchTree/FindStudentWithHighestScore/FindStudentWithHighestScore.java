package BigOCoding.BinarySearchTree.FindStudentWithHighestScore;

import java.util.Scanner;

public class FindStudentWithHighestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            Student student = new Student(scanner.next(), scanner.next(), scanner.nextDouble());
            binarySearchTree.add(student);
        }
        binarySearchTree.printHighestScoreStudent();

    }
}

class Student {
    String studentId;
    String name;
    double grade;

    public Student(String studentId, String name, double grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return studentId + " " + name + " " + grade;
    }
}

class Node {
    Student data;
    Node left, right;

    public Node(Student data) {
        this.data = data;
        left = right = null;
    }

    public void add(Student input) {
        if (input.grade < data.grade) {
            if (left == null) {
                left = new Node(input);
            } else {
                left.add(input);
            }
        } else if (input.grade > data.grade) {
            if (right == null) {
                right = new Node(input);
            } else {
                right.add(input);
            }
        } else {
            System.out.println("Exist node: " + input);
        }
    }

    public void printHighestScoreStudent() {
        if (right != null) {
            right.printHighestScoreStudent();
        } else {
            System.out.println(data);
        }
    }

}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Student input) {
        if (root == null) {
            root = new Node(input);
        } else {
            root.add(input);
        }
    }

    public void printHighestScoreStudent() {
        if (root != null) {
            root.printHighestScoreStudent();
        }
    }
}