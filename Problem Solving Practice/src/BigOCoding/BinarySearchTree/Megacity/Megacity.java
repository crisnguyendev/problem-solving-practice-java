package BigOCoding.BinarySearchTree.Megacity;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Megacity {
    private static final int TARGET_POPULATION = 1000000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Location> minHeap = new PriorityQueue<>();
        int totalLocation = scanner.nextInt();
        int currentPopulation = scanner.nextInt();
        for (int i = 0; i < totalLocation; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int radius = x * x + y * y;
            int population = scanner.nextInt();
            minHeap.add(new Location(radius, population));
        }
        double minimumRadius = minimumRadius(currentPopulation, minHeap);
        System.out.println(minimumRadius);
    }

    private static double minimumRadius(int currentPopulation, PriorityQueue<Location> minHeap) {

        while (!minHeap.isEmpty()) {
            Location location = minHeap.poll();
            currentPopulation += location.population;
            if (currentPopulation >= TARGET_POPULATION) {
                return Math.sqrt(location.radius);
            }
        }
        return -1;
    }
}

class Location implements Comparable<Location> {
    int radius;
    int population;

    public Location(int radius, int population) {
        this.radius = radius;
        this.population = population;
    }

    @Override
    public int compareTo(Location location) {
        return radius - location.radius;
    }
}
