package LeetCode.Medium.NumberOfIsland;

import java.util.Stack;

class Solution {
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int X;
    private int Y;

    public int numIslands(char[][] grid) {
        X = grid.length;
        Y = grid[0].length;
        visited = new boolean[X][Y];
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    dfs(new Land(x, y), grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(Land land, char[][] grid) {
        Stack<Land> stack = new Stack<>();
        stack.push(land);
        visited[land.x][land.y] = true;
        while (!stack.isEmpty()) {
            Land currentLand = stack.pop();
            for (int i = 0; i < 4; i++) {
                int x = currentLand.x + dx[i];
                int y = currentLand.y + dy[i];
                if (!isValid(x, y) || visited[x][y])
                    continue;
                if (grid[x][y] == '1') {
                    stack.push(new Land(x, y));
                }
                visited[x][y] = true;
            }
        }
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}

class OptimalSolution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    private int X;
    private int Y;

    public int numIslands(char[][] grid) {
        X = grid.length;
        Y = grid[0].length;
        int count = 0;
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (grid[x][y] == '1') {
                    mark(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    private void mark(char[][] grid, int x, int y) {
        grid[x][y] = 'x';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValid(newX, newY) && grid[newX][newY] == '1') {
                mark(grid, newX, newY);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}

class Land {
    int x;
    int y;

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfIsland {

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
