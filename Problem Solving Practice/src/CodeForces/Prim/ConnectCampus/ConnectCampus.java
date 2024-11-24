package CodeForces.Prim.ConnectCampus;

import java.util.*;

public class ConnectCampus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBuildings = scanner.nextInt();
        Building[] buildings = new Building[numberOfBuildings + 1];
        for (int i = 1; i <= numberOfBuildings; i++) {
            buildings[i] = new Building(scanner.nextInt(), scanner.nextInt());
        }
        int numberOfCables = scanner.nextInt();
        List<List<Node>> cables = new ArrayList<>();
        for (int i = 0; i <= numberOfBuildings; i++) {
            cables.add(new ArrayList<>());
        }
        for (int i = 0; i < numberOfCables; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            double weight = Math.sqrt(
                    Math.pow(buildings[source].x - buildings[destination].x, 2)
                            + Math.pow(buildings[source].y - buildings[destination].y, 2));
            cables.get(source).add(new Node(destination, weight));
            cables.get(destination).add(new Node(source, weight));
        }
        prim(numberOfBuildings, cables);
    }

    private static void prim(int numberOfBuildings, List<List<Node>> cables) {
        boolean[] visited = new boolean[numberOfBuildings + 1];
        double[] distance = new double[numberOfBuildings + 1];
        int[] path = new int[numberOfBuildings + 1];
        Arrays.fill(distance, Double.MAX_VALUE);
        Arrays.fill(path, -1);
        distance[1] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(1, 0));
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            visited[node.id] = true;
            if (distance[node.id] < node.weight)
                continue;
            for (Node neighbor : cables.get(node.id)) {
                if (!visited[neighbor.id] && distance[neighbor.id] > neighbor.weight) {
                    distance[neighbor.id] = neighbor.weight;
                    path[neighbor.id] = node.id;
                    priorityQueue.add(new Node(neighbor.id, distance[neighbor.id]));
                }
            }
        }

        double minDistance = 0;
        for (int i = 1; i <= numberOfBuildings; i++) {
            if (distance[i] == Double.MAX_VALUE)
                continue;
            minDistance += distance[i];
        }
        System.out.printf("%.2f", minDistance);
    }

    static class Node implements Comparable<Node> {
        int id;
        double weight;

        Node(int id, double weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            if (this.weight == node.weight)
                return 0;
            if (this.weight > node.weight)
                return 1;
            return -1;
        }
    }

    static class Building {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
