package LeetCode.Medium.NetworkDelayTime;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private int[] distance;
    private int[][] adjMatrix;

    public int networkDelayTime(int[][] times, int n, int k) {
        distance = new int[n + 1];
        adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < times.length; i++) {
            adjMatrix[times[i][0]][times[i][1]] = times[i][2];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        dijkstra(k);
        int minTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                minTime = Math.max(minTime, distance[i]);
            } else {
                return -1;
            }
        }
        return minTime;
    }

    private void dijkstra(int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        minHeap.add(new Node(k, 0));
        distance[k] = 0;
        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            if (currentNode.distance > distance[currentNode.id])
                continue;
            for (int i = 1; i < adjMatrix[currentNode.id].length; i++) {
                if (adjMatrix[currentNode.id][i] > 0 && currentNode.distance + adjMatrix[currentNode.id][i] < distance[i]) {
                    distance[i] = currentNode.distance + adjMatrix[currentNode.id][i];
                    minHeap.add(new Node(i, distance[i]));
                }
            }
        }
    }
}

class OptimalSolution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u][v] = w;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, k});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0], node = current[1];


            if (time > dist[node]) continue;


            for (int neighbor = 1; neighbor <= n; neighbor++) {
                if (graph[node][neighbor] != Integer.MAX_VALUE) {
                    int newTime = time + graph[node][neighbor];
                    if (newTime < dist[neighbor]) {
                        dist[neighbor] = newTime;
                        minHeap.add(new int[]{newTime, neighbor});
                    }
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

class Node {
    int id;
    int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }
}

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {
                {3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59},
                {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43},
                {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16},
                {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0},
                {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}
        };
        Arrays.sort(times, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = 5;
        int k = 5;
        System.out.println(new OptimalSolution().networkDelayTime(times, n, k));
    }
}
