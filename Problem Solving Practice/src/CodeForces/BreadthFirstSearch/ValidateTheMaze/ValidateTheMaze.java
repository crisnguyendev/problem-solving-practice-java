package CodeForces.BreadthFirstSearch.ValidateTheMaze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValidateTheMaze {

    private static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int rows;
    private static int cols;
    private static ArrayList<ArrayList<Character>> maze;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            maze = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                ArrayList<Character> row = new ArrayList<>();
                String rowInput = scanner.next();
                for (int k = 0; k < cols; k++) {
                    row.add(rowInput.charAt(k));
                }
                maze.add(row);
            }
            System.out.println(isValidMaze(maze)? "valid" : "invalid");
        }

    }

    private static boolean isValidMaze(ArrayList<ArrayList<Character>> maze) {
        ArrayList<Node> entrances = getEntrance(maze);
        if (entrances.size() != 2)
            return false;
        return findPath(maze, entrances.get(0), entrances.get(1));
    }

    private static boolean findPath(ArrayList<ArrayList<Character>> maze, Node entry, Node exit) {
        int MAX = 21;
        int[] nextX = {0, 0, 1, -1};
        int[] nextY = {1, -1, 0, 0};
        boolean[][] visited = new boolean[MAX][MAX];
        Queue<Node> queue = new LinkedList<>();
        queue.add(entry);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == exit.x && current.y == exit.y) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int newX = current.x + nextX[k];
                int newY = current.y + nextY[k];
                if (isValidNode(newX, newY) && !visited[newX][newY] && maze.get(newX).get(newY) == '.') {
                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY));
                }
            }

        }
        return false;
    }

    private static boolean isValidNode(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


    private static ArrayList<Node> getEntrance(ArrayList<ArrayList<Character>> maze) {
        ArrayList<Node> entrances = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze.get(i).get(j) == '.' && (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)) {
                    entrances.add(new Node(i, j));
                }
            }
        }
        return entrances;
    }
}
