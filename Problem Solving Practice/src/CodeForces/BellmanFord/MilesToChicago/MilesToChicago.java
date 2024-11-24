package CodeForces.BellmanFord.MilesToChicago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MilesToChicago {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numberOfIntersections = scanner.nextInt();
            if (numberOfIntersections == 0)
                break;
            int numberOfStreets = scanner.nextInt();
            List<Street> streets = new ArrayList<>();
            for (int j = 0; j < numberOfStreets; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int successRate = scanner.nextInt();
                streets.add(new Street(start, end, (double) successRate / 100));
            }
            double[] successRate = getSuccessRate(1, numberOfIntersections, streets);
            System.out.printf("%.6f percent\n", successRate[numberOfIntersections] * 100.0);
        }

    }

    private static double[] getSuccessRate(int start, int numberOfIntersections, List<Street> streets) {
        double[] successRate = new double[numberOfIntersections + 1];
        Arrays.fill(successRate, Integer.MIN_VALUE);
        successRate[start] = 1;
        for (int i = 1; i <= numberOfIntersections - 1; i++) {
            for (Street street : streets) {
                successRate[street.start] = Math.max(successRate[street.start], successRate[street.end] * street.successRate);
                successRate[street.end] = Math.max(successRate[street.end], successRate[street.start] * street.successRate);
            }
        }
        return successRate;
    }
}

class Street {
    int start;
    int end;
    double successRate;

    public Street(int start, int end, double successRate) {
        this.start = start;
        this.end = end;
        this.successRate = successRate;
    }
}
