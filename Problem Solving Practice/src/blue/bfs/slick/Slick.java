package blue.bfs.slick;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Slick {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] slick;
    private static boolean[][] visited;
    private static final int MAX_SIZE = 251;

    private static class Node {
        private final int n;
        private final int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            if (N == 0 && M == 0)
                break;
            map = new int[N][M];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    map[n][m] = scanner.nextInt();
                }
            }
            findSlicks();
        }
    }

    private static void findSlicks() {
        int totalSlick = 0;
        visited = new boolean[N][M];
        slick = new int[MAX_SIZE * MAX_SIZE];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visited[n][m] && map[n][m] == 1) {
                    bfs(new Node(n, m));
                    totalSlick++;
                }
            }
        }
        System.out.println(totalSlick);
        for (int i = 1; i < MAX_SIZE * MAX_SIZE; i++) {
            if (slick[i] != 0) {
                System.out.println(i + " " + slick[i]);
            }
        }
    }

    private static void bfs(Node root) {
        int[] nearByRow = {0, 0, -1, 1};
        int[] nearByColumn = {-1, 1, 0, 0};
        int size = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        visited[root.n][root.m] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            visited[currentNode.n][currentNode.m] = true;
            for (int i = 0; i < 4; i++) {
                int n = currentNode.n + nearByRow[i];
                int m = currentNode.m + nearByColumn[i];
                if (!isValid(n, m))
                    continue;
                if (map[n][m] == 1 && !visited[n][m]) {
                    visited[n][m] = true;
                    size++;
                    queue.add(new Node(n, m));
                }
            }
        }
        slick[size]++;
    }

    private static boolean isValid(int n, int m) {
        return n >= 0 && n < N && m >= 0 && m < M;
    }
}
