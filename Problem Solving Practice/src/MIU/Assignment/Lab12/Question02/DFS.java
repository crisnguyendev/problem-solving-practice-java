package MIU.Assignment.Lab12.Question02;

import java.util.Scanner;
import java.util.Stack;

public class DFS {
    private static int n;
    private static int[][] matrix;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        matrix = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int component = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                component++;
            }
        }
        System.out.println(component);
    }

    private static void dfs(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        while (!stack.isEmpty()) {
            int y = stack.pop();
            for (int i = 0; i < n; i++) {
                if (matrix[y][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
