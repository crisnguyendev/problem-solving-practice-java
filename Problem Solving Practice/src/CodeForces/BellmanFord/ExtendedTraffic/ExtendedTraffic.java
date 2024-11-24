package CodeForces.BellmanFord.ExtendedTraffic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtendedTraffic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestcases = scanner.nextInt();
        for (int i = 0; i < totalTestcases; i++) {
            int totalJunctions = scanner.nextInt();
            int[] junctions = new int[totalJunctions + 1];
            for (int j = 1; j <= totalJunctions; j++) {
                junctions[j] = scanner.nextInt();
            }
            int totalRoads = scanner.nextInt();
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < totalRoads; j++) {
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                edges.add(new Edge(source, destination, (int) Math.pow((junctions[destination] - junctions[source]), 3)));
            }
            int totalQueries = scanner.nextInt();
            int[] cost = bellmanFord(totalJunctions, edges);
            System.out.printf("Case %d:\n", i + 1);
            for (int j = 0; j < totalQueries; j++) {
                int destinationJunction = scanner.nextInt();
                if (cost[destinationJunction] < 3 || cost[destinationJunction] == Integer.MAX_VALUE)
                    System.out.println("?");
                else
                    System.out.println(cost[destinationJunction]);
            }

        }
    }

    private static int[] bellmanFord(int totalJunctions, List<Edge> edges) {
        int[] cost = new int[totalJunctions + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        for (int i = 0; i < totalJunctions - 1; i++) {
            for (Edge edge : edges) {
                if (cost[edge.source] != Integer.MAX_VALUE) {
                    cost[edge.destination] = Math.min(cost[edge.source] + edge.cost, cost[edge.destination]);
                }
            }
        }
        return cost;
    }
}

class Edge {
    int source;
    int destination;
    int cost;

    public Edge(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}
