package LeetCode.Medium.MaxAreaOfIsland;

class Solution {
    int X;
    int Y;
    int[] nearByX = {0, 0, -1, 1};
    int[] nearByY = {-1, 1, 0, 0};
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        X = grid.length;
        Y = grid[0].length;
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (grid[x][y] == 1) {
                    maxArea = Math.max(maxArea, mark(grid, x, y));
                }
            }
        }
        return maxArea;
    }

    private int mark(int[][] grid, int x, int y) {
        grid[x][y] = -1;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + nearByX[i];
            int newY = y + nearByY[i];
            if (isValid(newX, newY) && grid[newX][newY] == 1) {
                area += mark(grid, newX, newY);
            }
        }
        return area;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
}

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }


}
