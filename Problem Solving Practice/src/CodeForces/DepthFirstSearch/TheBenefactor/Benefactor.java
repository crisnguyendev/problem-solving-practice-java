package CodeForces.DepthFirstSearch.TheBenefactor;

import java.util.Scanner;
import java.util.Stack;

public class Benefactor {
    private static int V;
    private static int E;
    private static int[][] graph;
    private static int maxDistance;
    private static int leaf;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            V = scanner.nextInt();
            E = V - 1;
            graph = new int[V + 1][V + 1];
            maxDistance = 0;
            leaf = 1;
            for (int j = 0; j < E; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int length = scanner.nextInt();
                graph[u][v] = length;
                graph[v][u] = length;
            }

            dfs(1);
            dfs(leaf);
            System.out.println(maxDistance);
        }
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v = 0; v <= V; v++) {
                if (!visited[v] && graph[u][v] > 0) {
                    visited[v] = true;
                    distance[v] = distance[u] + graph[u][v];
                    stack.push(v);
                    if (distance[v] > maxDistance) {
                        maxDistance = distance[v];
                        leaf = v;
                    }
                }
            }
        }
    }
}
