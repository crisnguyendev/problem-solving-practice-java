package BigOCoding.DepthFirstSearch.LakesInBerland;

import java.util.*;

public class LakesInBerland {
    private static int N;
    private static int M;
    private static int K;
    private static char[][] map;
    private static final int[] nearByRow = {0, 0, -1, 1};
    private static final int[] nearByCol = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static ArrayList<ArrayList<Cell>> lakesInBerland;

    private static class Cell {
        private final int n;
        private final int m;

        public Cell(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M];
        lakesInBerland = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            String line = scanner.next();
            for (int m = 0; m < M; m++) {
                map[n][m] = line.charAt(m);
            }
        }
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == '*') {
                    visited[n][m] = true;
                } else if (!visited[n][m]) {
                    dfs(new Cell(n, m));
                }
            }
        }
        int result = 0;
        lakesInBerland.sort(Comparator.comparingInt(ArrayList::size));
        for (int i = 0; i < lakesInBerland.size() - K; i++) {
            ArrayList<Cell> cells = lakesInBerland.get(i);
            for (Cell cell : cells) {
                map[cell.n][cell.m] = '*';
                result++;
            }
        }
        System.out.println(result);
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                System.out.print(map[n][m]);
            }
            if (n != N - 1) {
                System.out.println();
            }
        }

    }

    private static void dfs(Cell source) {
        ArrayList<Cell> cells = new ArrayList<>();
        Stack<Cell> stack = new Stack<>();
        stack.push(source);
        cells.add(source);
        visited[source.n][source.m] = true;
        boolean isConnectedOcean = isConnectedOcean(source.n, source.m);
        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int n = current.n + nearByRow[i];
                int m = current.m + nearByCol[i];
                if (!isValidCell(n, m) || visited[n][m])
                    continue;
                if (map[n][m] == '.') {
                    if (isConnectedOcean(n, m))
                        isConnectedOcean = true;
                    stack.push(new Cell(n, m));
                    cells.add(new Cell(n, m));
                }

                visited[n][m] = true;
            }
        }
        if (!isConnectedOcean) {
            lakesInBerland.add(cells);
        }
    }

    private static boolean isValidCell(int n, int m) {
        return n >= 0 && n < N && m >= 0 && m < M;
    }

    private static boolean isConnectedOcean(int n, int m) {
        return n == 0 || n == N - 1 || m == 0 || m == M - 1;
    }
}
