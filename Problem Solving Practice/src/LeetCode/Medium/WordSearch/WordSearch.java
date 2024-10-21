package LeetCode.Medium.WordSearch;

class Solution {
    private boolean[][] visited;
    private int X;
    private int Y;
    private int[] nearByX = {0, 0, -1, 1};
    private int[] nearByY = {1, -1, 0, 0};


    private boolean found = false;

    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(new Solution().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        X = board.length;
        Y = board[0].length;
        visited = new boolean[X][Y];
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (found)
                    return true;
                if (board[x][y] == word.charAt(0)) {
                    recursiveDFS(board, x, y, word, 0);
                }
            }

        }
        return found;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < X && y >= 0 && y < Y;
    }

    private void recursiveDFS(char[][] board, int x, int y, String word, int charIndex) {
        if (charIndex == word.length() - 1) {
            found = true;
            return;
        }
        if (found)
            return;
        for (int i = 0; i < 4; i++) {
            int newX = x + nearByX[i];
            int newY = y + nearByY[i];
            if (isValid(newX, newY) && !visited[newX][newY] && board[newX][newY] == word.charAt(charIndex + 1)) {
                visited[x][y] = true;
                recursiveDFS(board, newX, newY, word, charIndex + 1);
                visited[x][y] = false;
            }
        }
    }
}




