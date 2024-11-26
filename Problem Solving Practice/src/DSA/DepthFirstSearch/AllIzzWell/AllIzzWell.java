package DSA.DepthFirstSearch.AllIzzWell;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AllIzzWell {

    private static int R;
    private static int C;
    private static char[][] matrix;
    private static ArrayList<Cell> listA;
    private static final int[] neighbourByRow = {-1, 1, 0, 0, -1, 1, 1, -1};
    private static final int[] neighbourByCol = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final String sentence = "ALLIZZWELL";

    private static class Cell {
        private final int r;
        private final int c;
        private final String sentence;

        public Cell(int r, int c, String sentence) {
            this.r = r;
            this.c = c;
            this.sentence = sentence;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            matrix = new char[R][C];
            listA = new ArrayList<>();

            for (int r = 0; r < R; r++) {
                String s = scanner.next();
                for (int c = 0; c < C; c++) {
                    matrix[r][c] = s.charAt(c);
                    if (s.charAt(c) == 'A')
                        listA.add(new Cell(r, c, String.valueOf('A')));
                }
            }
            System.out.println(existSentence() ? "YES" : "NO");
        }
    }

    public static boolean existSentence() {
        for (Cell cell : listA) {
            if (findSentence(cell))
                return true;
        }
        return false;
    }

    private static boolean findSentence(Cell cell) {
        boolean[][] visited = new boolean[R][C];
        Stack<Cell> stack = new Stack<>();
        stack.push(cell);
        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();
            for (int i = 0; i < 8; i++) {
                int r = currentCell.r + neighbourByRow[i];
                int c = currentCell.c + neighbourByCol[i];
                if (!isValidPosition(r, c))
                    continue;
                String nextWord = currentCell.sentence + matrix[r][c];
                if (sentence.contains(nextWord) && !visited[r][c]) {
                    stack.push(new Cell(r, c, nextWord));
                    visited[r][c] = true;
                } else {
                    visited[r][c] = false;
                }
                if (sentence.equals(nextWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPosition(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
