package BigOCoding.Dijkstra.Commandos;

import java.util.*;

public class Commandos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();
        for (int i = 0; i < totalTestCases; i++) {
            int totalBuildings = scanner.nextInt();
            List<List<Integer>> adjBuildings = new ArrayList<>();
            for (int j = 0; j < totalBuildings; j++) {
                adjBuildings.add(new ArrayList<>());
            }
            int totalRoads = scanner.nextInt();
            for (int j = 0; j < totalRoads; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjBuildings.get(u).add(v);
                adjBuildings.get(v).add(u);
            }
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int[] timeFromStart = bfs(start, totalBuildings, adjBuildings);
            int[] timeFromEnd = bfs(end, totalBuildings, adjBuildings);
            int max = 0;
            for (int j = 0; j < totalBuildings; j++) {
                max = Math.max(max, timeFromStart[j] + timeFromEnd[j]);
            }
            System.out.printf("Case %d: %d\n", i + 1, max);
        }
    }

    private static int[] bfs(int start, int totalBuildings, List<List<Integer>> adjBuildings) {
        boolean[] visited = new boolean[totalBuildings];
        int[] distance = new int[totalBuildings];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int currentBuilding = queue.poll();
            visited[start] = true;
            for (Integer adjBuilding : adjBuildings.get(currentBuilding)) {
                if (!visited[adjBuilding]) {
                    visited[adjBuilding] = true;
                    distance[adjBuilding] = distance[currentBuilding] + 1;
                    queue.add(adjBuilding);
                }
            }
        }
        return distance;
    }
}

