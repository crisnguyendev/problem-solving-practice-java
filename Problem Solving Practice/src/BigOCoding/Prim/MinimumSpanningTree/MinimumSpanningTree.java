package BigOCoding.Prim.MinimumSpanningTree;

import java.util.Scanner;

public class MinimumSpanningTree {
    private static int[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        nodes = new int[numberOfNodes + 1];
        for (int i = 0; i < numberOfEdges; i++) {
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int weight;

        Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }
}

