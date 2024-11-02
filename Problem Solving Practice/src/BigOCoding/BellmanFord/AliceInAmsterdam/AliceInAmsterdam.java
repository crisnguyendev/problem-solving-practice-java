package BigOCoding.BellmanFord.AliceInAmsterdam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AliceInAmsterdam {
    private static int[][] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 1;
        while (scanner.hasNext()) {
            int numberOfMonuments = scanner.nextInt();
            if (numberOfMonuments == 0)
                break;

            System.out.printf("Case #%d:\n", testCase++);
            String[] monuments = new String[numberOfMonuments];
            distance = new int[numberOfMonuments][numberOfMonuments];
            List<Path> paths = new ArrayList<>();
            for (int i = 0; i < numberOfMonuments; i++) {
                monuments[i] = scanner.next();
                for (int j = 0; j < numberOfMonuments; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                    int distance = scanner.nextInt();
                    if (i != j && distance == 0)
                        continue;
                    if (i == j && distance > 0)
                        distance = 0;
                    paths.add(new Path(i, j, distance));
                }
            }
            for (int i = 0; i < numberOfMonuments; i++) {
                bellmanFord(i, numberOfMonuments, paths);
            }


            int numberOfQueries = scanner.nextInt();

            for (int i = 0; i < numberOfQueries; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (distance[start][end] <= Integer.MIN_VALUE)
                    System.out.println("NEGATIVE CYCLE");
                else {
                    System.out.print(monuments[start] + "-" + monuments[end] + " ");
                    System.out.println(distance[start][end] == Integer.MAX_VALUE ? "NOT REACHABLE" : distance[start][end]);
                }

            }
        }
    }

    private static void bellmanFord(int start, int numberOfMonuments, List<Path> paths) {
        distance[start][start] = 0;
        for (int k = 0; k < numberOfMonuments - 1; k++) {
            for (Path path : paths) {
                if (distance[start][path.source] != Integer.MAX_VALUE && distance[start][path.source] + path.distance < distance[start][path.target])
                    distance[start][path.target] = distance[start][path.source] + path.distance;
            }
        }

        for (int k = 0; k < numberOfMonuments - 1; k++) {
            for (Path path : paths) {
                if (distance[start][path.source] != Integer.MAX_VALUE && distance[start][path.source] + path.distance < distance[start][path.target])
                    distance[start][path.target] = Integer.MIN_VALUE;
            }
        }
    }
}

class Path {
    int source;
    int target;
    int distance;

    public Path(int source, int target, int distance) {
        this.source = source;
        this.target = target;
        this.distance = distance;
    }
}
