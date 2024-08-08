package blue.bfs.shortestreach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
    private static ArrayList<ArrayList<Integer>> graph;
    private static ArrayList<Integer> distance;
    private static ArrayList<Boolean> visited;
    private static int V;
    private static int E;
    private static final int EDGE_LENGTH = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            V = scanner.nextInt();
            graph = new ArrayList<>();
            distance = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                graph.add(new ArrayList<>());
                distance.add(0);
            }
            E = scanner.nextInt();
            for (int j = 0; j < E; j++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int s = scanner.nextInt() - 1;
            bfs(s);
            for (int j = 0; j < V; j++) {
                if (j == s)
                    continue;
                System.out.print(visited.get(j) ? distance.get(j) : -1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    private static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        distance = new ArrayList<>();
        visited = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            visited.add(false);
            distance.add(-1);
        }
        visited.set(s, true);
        queue.add(s);
        distance.set(s, 0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);
                if (!visited.get(v)) {
                    visited.set(v, true);
                    distance.set(v, distance.get(u) + EDGE_LENGTH);
                    queue.add(v);
                }
            }
        }
    }
}
