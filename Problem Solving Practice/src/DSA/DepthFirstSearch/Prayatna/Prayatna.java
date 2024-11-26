package DSA.DepthFirstSearch.Prayatna;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Prayatna {
    private static int N;
    private static int E;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            N = scanner.nextInt();
            E = scanner.nextInt();
            graph = new ArrayList<>();
            visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                graph.add(new ArrayList<>());
            }
            for (int e = 0; e < E; e++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    count++;
                    dfs(j);
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            if(!visited[u]) {
                visited[u] = true;
            }
            boolean allChildVisited = true;
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                    allChildVisited = false;
                    break;
                }
            }
            if (allChildVisited) {
                stack.pop();
            }
        }
    }
}
