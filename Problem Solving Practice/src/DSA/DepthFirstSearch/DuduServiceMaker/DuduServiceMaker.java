package DSA.DepthFirstSearch.DuduServiceMaker;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DuduServiceMaker {
    private static int N;
    private static int M;
    private static int[] visited;
    private static boolean[] inPath;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            visited = new int[N + 1];
            graph = new ArrayList<>();
            for (int n = 0; n <= N; n++) {
                graph.add(new ArrayList<>());
            }
            for (int m = 0; m < M; m++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                graph.get(A).add(B);
            }
            System.out.println(findLoop());
        }
    }

    private static String findLoop() {
        for (int n = 1; n <= N; n++) {
            if (visited[n] == 0 && dfsExistLoop(n))
                return "YES";
        }
        return "NO";
    }


    private static boolean dfsExistLoop(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = 1;
        while (!stack.isEmpty()) {
            int A = stack.pop();
            for (int B : graph.get(A)) {
                if (visited[B] == 1) {
                    return true;
                }
                stack.push(B);
                visited[B] = 1;
            }
            visited[start] = 2;
        }
        return false;
    }
}
