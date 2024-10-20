package MIU.Assignment.Lab12.Question03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
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
            if (!visited[i]) {
                component++;
                System.out.println("Component " + component);
                bfs(i);
                System.out.println();
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int y = queue.poll();
            System.out.print((char)(y + 'A') + " ");
            for (int i = 0; i < n; i++) {
                if (matrix[y][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
