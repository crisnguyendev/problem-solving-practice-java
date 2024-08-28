package BigOCoding.DepthFirstSearch.ABCPath;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ABCPath {
    private static int H;
    private static int W;
    private static char[][] grid;
    private static ArrayList<Cell> startCells;
    private static final int[] adjacentX = {0, 1, -1, 0, 1, 1, -1, -1};
    private static final int[] adjacentY = {1, 0, 0, -1, 1, -1, 1, -1};
    private static boolean[][] visited;
    private static int maxLength;

    private static class Cell {
        private final int h;
        private final int w;

        public Cell(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            H = scanner.nextInt();
            W = scanner.nextInt();
            if (H == 0 && W == 0) break;
            grid = new char[H][W];
            startCells = new ArrayList<>();
            visited = new boolean[H][W];
            maxLength = 0;
            i++;
            for (int h = 0; h < H; h++) {
                String line = scanner.next();
                for (int w = 0; w < W; w++) {
                    grid[h][w] = line.charAt(w);
                    if (grid[h][w] == 'A')
                        startCells.add(new Cell(h, w));
                }
            }
            for (Cell cell : startCells) {
                dfs(cell);
            }
            System.out.println("Case " + i + ": " + maxLength);
        }
    }

    private static void dfs(Cell startCell) {
        Stack<Cell> stack = new Stack<>();
        stack.push(startCell);
        visited[startCell.h][startCell.w] = true;
        maxLength = Math.max(maxLength, grid[startCell.h][startCell.w] - 'A' + 1);
        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            for (int i = 0; i < 8; i++) {
                int h = current.h + adjacentX[i];
                int w = current.w + adjacentY[i];
                if (!isValidCell(h, w) || visited[h][w])
                    continue;
                if (grid[h][w] - grid[current.h][current.w] == 1) {
                    stack.push(new Cell(h, w));
                    visited[h][w] = true;
                    maxLength = Math.max(maxLength, grid[h][w] - 'A' + 1);
                }
            }
        }
    }

    private static boolean isValidCell(int h, int w) {
        return h >= 0 && h < H && w >= 0 && w < W;
    }
}
