package BigOCoding.Dijkstra.TrafficNetwork;

import java.util.*;

public class TrafficNetwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = scanner.nextInt();
        for (int j = 0; j < numberOfTestCase; j++) {
            int numberOfNodes = scanner.nextInt();
            List<List<Node>> oneWayEdges = new ArrayList<>();
            List<List<Node>> reversedOneWayEdges = new ArrayList<>();
            for (int i = 0; i <= numberOfNodes; i++) {
                oneWayEdges.add(new ArrayList<>());
                reversedOneWayEdges.add(new ArrayList<>());
            }
            int numberOfOneWayRoad = scanner.nextInt();
            int numberOfTwoWayRoad = scanner.nextInt();
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for (int i = 0; i < numberOfOneWayRoad; i++) {
                int d = scanner.nextInt();
                int c = scanner.nextInt();
                int l = scanner.nextInt();
                oneWayEdges.get(d).add(new Node(c, l));
                reversedOneWayEdges.get(c).add(new Node(d, l));
            }
            int[] costFromStart = dijkstra(start, numberOfNodes, oneWayEdges);
            int[] costReversedFromEnd = dijkstra(end, numberOfNodes, reversedOneWayEdges);
            long minCost = costFromStart[end];
            for (int i = 0; i < numberOfTwoWayRoad; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int length = scanner.nextInt();
                long newMinCost = Math.min(
                        (long) costFromStart[u] + costReversedFromEnd[v] + length,
                        (long) costFromStart[v] + costReversedFromEnd[u] + length);
                minCost = Math.min(minCost, newMinCost);

            }
            System.out.println(minCost >= Integer.MAX_VALUE ? -1 : minCost);
        }

    }

    private static int[] dijkstra(int start, int numberOfNodes, List<List<Node>> adjEdges) {
        int[] cost = new int[numberOfNodes + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        cost[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (Node neighbor : adjEdges.get(node.id)) {
                if (neighbor.length + cost[node.id] < cost[neighbor.id]) {
                    cost[neighbor.id] = neighbor.length + cost[node.id];
                    priorityQueue.add(new Node(neighbor.id, cost[neighbor.id]));
                }
            }
        }
        return cost;
    }
}

class Node implements Comparable<Node> {
    int id;
    int length;

    public Node(int id, int length) {
        this.id = id;
        this.length = length;
    }

    @Override
    public int compareTo(Node node) {
        return length - node.length;
    }
}
