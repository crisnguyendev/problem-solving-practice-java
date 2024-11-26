package DSA.DepthFirstSearch.TheLastShot;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TheLastShot {
    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int maxImpact;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        graph = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }
        for (int m = 0; m < M; m++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.get(A).add(B);
        }
        boolean[] visited = new boolean[N + 1];
        for (int n = 0; n <= N; n++) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
        System.out.println(maxImpact);
    }

    private static void dfs(int A) {
        boolean[] inPath = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(A);
        inPath[A] = true;
        int impact = 1;
        while (!stack.isEmpty()) {
            A = stack.pop();
            for (int B : graph.get(A)) {
                if (!inPath[B]) {
                    impact++;
                    inPath[B] = true;
                    stack.push(B);
                }
            }

        }
        if (impact > maxImpact) {
            maxImpact = impact;
        }
    }
}
