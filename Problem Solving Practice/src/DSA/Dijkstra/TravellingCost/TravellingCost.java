package DSA.Dijkstra.TravellingCost;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TravellingCost {
    private static int[] distance;
    private static int[] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        distance = new int[501];
        path = new int[501];
        List<List<Node>> adjEdges = new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            adjEdges.add(new ArrayList<>());
            path[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int cost = scanner.nextInt();
            adjEdges.get(u).add(new Node(v, cost));
            adjEdges.get(v).add(new Node(u, cost));
        }
        int U = scanner.nextInt();
        dijkstra(U, adjEdges);
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int V = scanner.nextInt();
            System.out.println(distance[V] != Integer.MAX_VALUE ? distance[V] : "NO PATH");
        }
    }

    private static void dijkstra(int start, List<List<Node>> adjEdges) {
        distance[start] = 0;
        path[start] = start;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            List<Node> adjNodes = adjEdges.get(node.id);
            for (Node adjNode : adjNodes) {
                if (node.cost + adjNode.cost < distance[adjNode.id]) {
                    distance[adjNode.id] = distance[node.id] + adjNode.cost;
                    path[adjNode.id] = node.id;
                    priorityQueue.add(new Node(adjNode.id, distance[adjNode.id]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }
}
