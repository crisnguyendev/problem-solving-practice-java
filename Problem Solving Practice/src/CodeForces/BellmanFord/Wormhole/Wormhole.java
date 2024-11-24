package CodeForces.BellmanFord.Wormhole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Wormhole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        for (int i = 0; i < totalCases; i++) {
            int totalSystems = scanner.nextInt();
            int totalWormholes = scanner.nextInt();
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < totalWormholes; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int t = scanner.nextInt();
                edges.add(new Edge(x, y, t));
            }
            System.out.println(existCycle(totalSystems, edges) ? "possible" : "not possible");
        }
    }

    private static boolean existCycle(int totalSystems, List<Edge> edges) {
        int[] cost = new int[totalSystems];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        for (int i = 0; i < totalSystems - 1; i++) {
            for (Edge edge : edges) {
                if (cost[edge.source] != Integer.MAX_VALUE && cost[edge.source] + edge.cost < cost[edge.destination]) {
                    cost[edge.destination] = cost[edge.source] + edge.cost;
                }
            }
        }
        for (Edge edge : edges) {
            if (cost[edge.source] != Integer.MAX_VALUE && cost[edge.source] + edge.cost < cost[edge.destination]) {
                return true;
            }
        }
        return false;
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
