package DSA.Dijkstra.ChocolateJourney;

import java.util.*;

public class ChocolateJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCities = scanner.nextInt();
        int totalRoads = scanner.nextInt();
        int k = scanner.nextInt();
        int expiryTime = scanner.nextInt();
        List<Integer> availableCities = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            availableCities.add(scanner.nextInt());
        }
        List<List<City>> adjCities = new ArrayList<>();
        for (int i = 0; i <= totalCities; i++) {
            adjCities.add(new ArrayList<>());
        }
        for (int i = 1; i <= totalRoads; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int distance = scanner.nextInt();
            adjCities.get(u).add(new City(v, distance));
            adjCities.get(v).add(new City(u, distance));
        }
        int friendCity = scanner.nextInt();
        int myCity = scanner.nextInt();
        int[] distanceFromFriendCity = dijkstra(friendCity, totalCities, adjCities);
        int[] distanceFromMyCity = dijkstra(myCity, totalCities, adjCities);
        long minDistance = Integer.MAX_VALUE;
        for (Integer city : availableCities) {
            if (distanceFromFriendCity[city] <= expiryTime)
                minDistance = Math.min(minDistance, (long) distanceFromFriendCity[city] + distanceFromMyCity[city]);
        }
        System.out.println(minDistance >= Integer.MAX_VALUE ? -1 : minDistance);
    }

    private static int[] dijkstra(int start, int totalCities, List<List<City>> adjCities) {
        int[] distances = new int[totalCities + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new City(start, 0));
        distances[start] = 0;
        while (!priorityQueue.isEmpty()) {
            City currentCity = priorityQueue.poll();
            if (distances[currentCity.id] < currentCity.distance)
                continue;
            for (City adjCity : adjCities.get(currentCity.id)) {
                int newDistance = distances[currentCity.id] + adjCity.distance;
                if (newDistance < distances[adjCity.id]) {
                    distances[adjCity.id] = newDistance;
                    priorityQueue.add(new City(adjCity.id, newDistance));
                }
            }
        }
        return distances;
    }
}

class City implements Comparable<City> {
    int id;
    int distance;

    public City(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(City city) {
        return distance - city.distance;
    }
}
