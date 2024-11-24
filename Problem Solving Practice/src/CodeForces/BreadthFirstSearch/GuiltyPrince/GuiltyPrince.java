package CodeForces.BreadthFirstSearch.GuiltyPrince;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuiltyPrince {

    private static int W;
    private static int H;
    private static String[] map;
    private static Node start;
    private static int[] nearbyX = {0, 1, -1, 0};
    private static int[] nearbyY = {1, 0, 0, -1};


    private static class Node {
        private int h, w;

        public Node(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            W = scanner.nextInt();
            H = scanner.nextInt();
            map = new String[H];
            for (int j = 0; j < H; j++) {
                String line = scanner.next();
                map[j] = line;
                if (line.contains("@")) {
                    start = new Node(j, line.indexOf("@"));
                }
            }
            System.out.println("Case " + (i + 1) + ": " + bfs(start));
        }
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        queue.add(start);
        int result = 1;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int h = current.h + nearbyX[i];
                int w = current.w + nearbyY[i];
                if (isValidNode(h, w) && !visited[h][w] && map[h].charAt(w) == '.') {
                    visited[h][w] = true;
                    result++;
                    queue.add(new Node(h, w));
                }
            }
        }
        return result;
    }

    private static boolean isValidNode(int h, int w) {
        return h >= 0 && h < H && w >= 0 && w < W;
    }
}
