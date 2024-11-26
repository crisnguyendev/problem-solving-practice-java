package DSA.Dijkstra.AlmostShortestPath;

import java.util.*;

public class AlmostShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int totalPoints = scanner.nextInt();
            int totalOneWayRoutes = scanner.nextInt();
            if (totalPoints == 0 && totalOneWayRoutes == 0)
                break;
            int startPoint = scanner.nextInt();
            int endPoint = scanner.nextInt();
            List<List<Point>> adjPoints = new ArrayList<>();
            List<List<Point>> reversedAdjPoints = new ArrayList<>();
            List<List<Point>> adjAlmostPoints = new ArrayList<>();
            for (int i = 0; i < totalPoints; i++) {
                adjPoints.add(new ArrayList<>());
                reversedAdjPoints.add(new ArrayList<>());
                adjAlmostPoints.add(new ArrayList<>());
            }
            for (int i = 0; i < totalOneWayRoutes; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                adjPoints.get(u).add(new Point(v, w));
                reversedAdjPoints.get(v).add(new Point(u, w));
            }
            int[] distanceFromStart = dijkstra(startPoint, totalPoints, adjPoints);
            int[] distanceFromEnd = dijkstra(endPoint, totalPoints, reversedAdjPoints);
            int shortestDistance = distanceFromStart[endPoint];
            for (int currentPointId = 0; currentPointId < totalPoints; currentPointId++) {
                for(Point adjPoint : adjPoints.get(currentPointId)) {
                    if(distanceFromStart[currentPointId] + distanceFromEnd[adjPoint.id] + adjPoint.distance != shortestDistance) {
                        adjAlmostPoints.get(currentPointId).add(adjPoint);
                    }
                }
            }
            int[] almostDistance = dijkstra(startPoint, totalPoints, adjAlmostPoints);
            int almostShortestDistance = almostDistance[endPoint];
            System.out.println(almostShortestDistance >= Integer.MAX_VALUE ? -1 : almostShortestDistance);
        }
    }

    private static int[] dijkstra(int startPoint, int totalPoints, List<List<Point>> adjPoints) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        int[] distance = new int[totalPoints];
        Arrays.fill(distance, Integer.MAX_VALUE);
        priorityQueue.add(new Point(startPoint, 0));
        distance[startPoint] = 0;
        while (!priorityQueue.isEmpty()) {
            Point currentPoint = priorityQueue.poll();
            for (Point adjPoint : adjPoints.get(currentPoint.id)) {
                int newDistance = distance[currentPoint.id] + adjPoint.distance;
                if (distance[adjPoint.id] > newDistance) {
                    distance[adjPoint.id] = newDistance;
                    priorityQueue.add(new Point(adjPoint.id, newDistance));
                }
            }
        }
        return distance;
    }
}

class Point implements Comparable<Point> {
    int id;
    int distance;

    public Point(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Point point) {
        return distance - point.distance;
    }
}
