package BigOCoding.BreadthFirstSearch.Dhoom4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dhoom4 {
    private static int X;
    private static int Z;
    private static int N;
    private static long[] y;
    private static Queue<Integer> queue;
    private static int[] distance;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        Z = scanner.nextInt();
        N = scanner.nextInt();
        distance = new int[100005];
        queue = new LinkedList<>();
        y = new long[100005];
        for (int i = 0; i < N; i++) {
            y[i] = scanner.nextInt();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        queue.add(X);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < N; i++) {
                Long longValue = (x * y[i]) % 100000;
                int newNode = longValue.intValue() ;
                if (distance[newNode] == 0) {
                    distance[newNode] = distance[x] + 1;
                    queue.add(newNode);
                    if (newNode == Z) {
                        return distance[newNode];
                    }
                }
            }
        }
        return -1;
    }
}
