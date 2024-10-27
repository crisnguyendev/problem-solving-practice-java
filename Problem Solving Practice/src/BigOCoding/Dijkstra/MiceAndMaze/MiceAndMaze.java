package BigOCoding.Dijkstra.MiceAndMaze;

import java.util.*;

public class MiceAndMaze {
    private static int[] time;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int E = scanner.nextInt();
        int T = scanner.nextInt();
        int M = scanner.nextInt();
        List<List<Node>> adjacencyList = new ArrayList<>();
        time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= N ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int time = scanner.nextInt();
            adjacencyList.get(end).add(new Node(start, time));
        }
        System.out.println(dijkstra(E, T, adjacencyList, N));

    }

    private static int dijkstra(int start, int maxTime, List<List<Node>> adjacencyList, int N) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        time[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            List<Node> adjNodes = adjacencyList.get(node.id);
            for (Node adjNode : adjNodes) {
                if (adjNode.time + time[node.id] < time[adjNode.id]) {
                    time[adjNode.id] = adjNode.time + time[node.id];
                    priorityQueue.add(new Node(adjNode.id, adjNode.time));
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (time[i] <= maxTime) {
                count++;
            }
        }
        return count;
    }
}

class Node implements Comparable<Node> {
    int id;
    int time;

    Node(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(Node node) {
        return time - node.time;
    }
}
