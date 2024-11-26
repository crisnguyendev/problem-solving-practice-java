package DSA.BellmanFord.SingleShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SingleShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numberOfNodes = scanner.nextInt();
            int numberOfEdges = scanner.nextInt();
            int numberOfQueries = scanner.nextInt();
            int start = scanner.nextInt();
            if (numberOfNodes == 0)
                break;
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < numberOfEdges; i++) {
                edges.add(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            }
            int[] distance = getMinDistance(start, numberOfNodes, edges);
            for (int i = 0; i < numberOfQueries; i++) {
                int destination = scanner.nextInt();
                if (distance[destination] == Integer.MAX_VALUE)
                    System.out.println("Impossible");
                else if (distance[destination] == Integer.MIN_VALUE)
                    System.out.println("-Infinity");
                else
                    System.out.println(distance[destination]);
            }
            System.out.println();
        }
    }

    private static int[] getMinDistance(int start, int numberOfNodes, List<Edge> edges) {
        int[] distance = new int[numberOfNodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for (int i = 0; i < numberOfNodes - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE)
                    distance[edge.destination] = Math.min(distance[edge.source] + edge.distance, distance[edge.destination]);
            }
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.distance < distance[edge.destination])
                    distance[edge.destination] = Integer.MIN_VALUE;
            }
        }
        return distance;
    }
}

class Edge {
    int source;
    int destination;
    int distance;

    public Edge(int source, int destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }
}
