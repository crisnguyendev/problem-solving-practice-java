package BigOCoding.Dijkstra.TheShortestPath;

import java.util.*;

public class TheShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        for (int i = 0; i < s; i++) {
            int n = scanner.nextInt();
            List<List<City>> adjacencyEdges = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                adjacencyEdges.add(new ArrayList<>());
            }
            List<String> cityNames = new ArrayList<>();
            cityNames.add("");
            for (int cityIndex = 1; cityIndex <= n; cityIndex++) {
                cityNames.add(scanner.next());
                int p = scanner.nextInt();
                for (int j = 0; j < p; j++) {
                    int neighborIndex = scanner.nextInt();
                    int cost = scanner.nextInt();
                    adjacencyEdges.get(cityIndex).add(new City(neighborIndex, cost));
                }

            }
            int r = scanner.nextInt();
            for (int j = 0; j < r; j++) {
                String source = scanner.next();
                String destination = scanner.next();
                System.out.println(dijkstra(cityNames.indexOf(source), cityNames.indexOf(destination), n, adjacencyEdges));
            }
        }
    }

    private static long dijkstra(int source, int destination, int numberOfCity, List<List<City>> adjecencyEdges) {
        long[] distance = new long[numberOfCity + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new City(source, 0));
        distance[source] = 0;
        while (!priorityQueue.isEmpty()) {
            City city = priorityQueue.poll();
            List<City> neighbourCities = adjecencyEdges.get(city.id);
            for (City neighbour : neighbourCities) {
                if (neighbour.cost + distance[city.id] < distance[neighbour.id]) {
                    distance[neighbour.id] = distance[city.id] + neighbour.cost;
                    priorityQueue.add(new City(neighbour.id, distance[neighbour.id]));
                }
            }
        }
        return distance[destination];

    }
}

class City implements Comparable<City> {
    int id;
    long cost;

    public City(int id, long cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public int compareTo(City city) {
        return (int) (cost - city.cost);
    }
}
