package DSA.BinarySearch.EnergyExchange;

import java.util.ArrayList;
import java.util.Scanner;

public class EnergyExchange {
    private static int n;
    private static int k;
    private static double totalEnergy;
    private static ArrayList<Integer> accumulators;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        accumulators = new ArrayList<>();
        totalEnergy = 0.0;
        for (int i = 0; i < n; i++) {
            int energy = scanner.nextInt();
            accumulators.add(energy);
            totalEnergy += energy;
        }
        System.out.printf("%.9f", calculateMaximumRemainEnergy());

    }

    private static double calculateMaximumRemainEnergy() {
        double left = 0;
        double right = 1000;
        double totalTransfer = 0;
        while (left + 1e-7 < right) {
            double mid = (left + right) / 2;
            totalTransfer = 0;
            for (Integer accumulator : accumulators) {
                if (accumulator > mid) {
                    totalTransfer += accumulator - mid;
                }
            }
            if (mid * n < totalEnergy - totalTransfer * k / 100) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
