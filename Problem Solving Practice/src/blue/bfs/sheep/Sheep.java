package blue.bfs.sheep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sheep {
    private static int N;
    private static int M;
    private static char[][] backyard;
    private static boolean[][] visited;
    private static int survivalSheep = 0;
    private static int survivalWolves = 0;
    private static final int[] nearByRow = {0, 0, -1, 1};
    private static final int[] nearByCol = {1, -1, 0, 0};

    private static class Field {
        private int n;
        private int m;

        public Field(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        backyard = new char[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            String line = scanner.next();
            for (int m = 0; m < M; m++) {
                backyard[n][m] = line.charAt(m);
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (backyard[n][m] != '#') {
                    BFS(new Field(n, m));
                }
                visited[n][m] = true;
            }
        }
        System.out.println(survivalSheep + " " + survivalWolves);
    }

    private static void BFS(Field field) {
        int sheep = 0;
        int wolves = 0;
        Queue<Field> queue = new LinkedList<>();
        queue.add(field);
        boolean isFreeSector = false;
        while (!queue.isEmpty()) {
            Field current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int n = current.n + nearByRow[i];
                int m = current.m + nearByCol[i];
                if (!isValidField(n, m) || visited[n][m]) {
                    continue;
                }
                char fieldValue = backyard[n][m];
                if (fieldValue != '#') {
                    queue.add(new Field(n, m));
                }
                if (fieldValue == '.' && isSideLine(n, m)) {
                    isFreeSector = true;
                }
                if (fieldValue == 'k') {
                    sheep++;
                }
                if (fieldValue == 'v') {
                    wolves++;
                }
                visited[n][m] = true;
            }
        }
        if (isFreeSector) {
            survivalSheep += sheep;
            survivalWolves += wolves;
        } else if (sheep > wolves) {
            survivalSheep += sheep;
        } else {
            survivalWolves += wolves;
        }
    }

    private static boolean isSideLine(int n, int m) {
        return n == 0 || m == 0 || n == N - 1 || m == M - 1;
    }

    private static boolean isValidField(int n, int m) {
        return n >= 0 && n < N && m >= 0 && m < M;
    }
}
