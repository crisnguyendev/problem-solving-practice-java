package DSA.BreadthFirstSearch.IceCave;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceCave {
    private static int N;
    private static int M;
    private static char[][] map;
    private static Cell startCell;
    private static Cell targetCell;
    private static final int[] nearByRow = {0, -1, 0, 1};
    private static final int[] nearByCol = {1, 0, -1, 0};

    private static class Cell {
        private int n;
        private int m;

        public Cell(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new char[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            String line = scanner.next();
            for (int m = 1; m <= M; m++) {
                map[n][m] = line.charAt(m - 1);
            }
        }
        startCell = new Cell(scanner.nextInt(), scanner.nextInt());
        targetCell = new Cell(scanner.nextInt(), scanner.nextInt());
        System.out.println(BFS());
    }

    private static String BFS() {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(startCell);
        map[startCell.n][startCell.m] = 'X';
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int n = current.n + nearByRow[i];
                int m = current.m + nearByCol[i];
                if (!isValid(n, m))
                    continue;
                if (n == targetCell.n && m == targetCell.m && map[n][m] == 'X')
                    return "YES";
                if (map[n][m] == '.') {
                    map[n][m] = 'X';
                    queue.add(new Cell(n, m));
                }
            }
        }
        return "NO";
    }

    private static boolean isValid(int n, int m) {
        return n >= 1 && n <= N && m >= 1 && m <= M;
    }
}
