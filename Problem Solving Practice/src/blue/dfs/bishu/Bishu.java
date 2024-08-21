package blue.dfs.bishu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Bishu {
    private static int N;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int[] distance;
    private static int Q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        graph = new ArrayList<>();
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(1);

        Q = scanner.nextInt();
        int minDistance = Integer.MAX_VALUE;
        int country = 0;
        for (int i = 0; i < Q; i++) {
            int v = scanner.nextInt();
            if (distance[v] < minDistance || (distance[v] == minDistance && v < country)) {
                minDistance = distance[v];
                country = v;
            }
        }
        System.out.println(country);
    }

    private static void dfs(int root) {
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    stack.push(v);
                }
            }
        }
    }
}
