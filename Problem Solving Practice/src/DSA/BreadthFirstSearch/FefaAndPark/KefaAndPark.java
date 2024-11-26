package DSA.BreadthFirstSearch.FefaAndPark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KefaAndPark {
    private static int n;
    private static int m;
    private static int[] cat;
    private static ArrayList<Integer>[] graph;
    private static int[] catInPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        cat = new int[n + 1];
        catInPath = new int[n + 1];
        m = scanner.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cat[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (graph[x] == null) {
                graph[x] = new ArrayList<>();
            }
            graph[x].add(y);
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        catInPath[1] = cat[1];
        while (!queue.isEmpty()) {
            int x = queue.poll();
            boolean isLeaf = isLeaf(x);
            if (!isLeaf) {
                if (catInPath[x] > m)
                    continue;
                for (int y : graph[x]) {
                    catInPath[y] = catInPath[x] + cat[y];
                    queue.add(y);
                }
            }

            if (isLeaf && catInPath[x] <= m + 1) {
                result++;
            }
        }
        return result;
    }

    private static boolean isLeaf(int x) {
        return graph[x] == null || graph[x].isEmpty();
    }
}
