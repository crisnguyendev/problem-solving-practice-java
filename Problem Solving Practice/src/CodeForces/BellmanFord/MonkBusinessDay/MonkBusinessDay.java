package CodeForces.BellmanFord.MonkBusinessDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MonkBusinessDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int testCaseNo = 1; testCaseNo <= numberOfTestCases; testCaseNo++) {
            int numberOfItems = scanner.nextInt();
            int numberOfDeals = scanner.nextInt();
            List<Deal> deals = new ArrayList<>();
            for (int deal = 1; deal <= numberOfDeals; deal++) {
                int source = scanner.nextInt();
                int target = scanner.nextInt();
                int cost = scanner.nextInt();
                deals.add(new Deal(source, target, -cost));
            }
            System.out.println(bellmanFord(1, numberOfItems, deals) ? "Yes" : "No");
        }
    }

    private static boolean bellmanFord(int start, int numberOfItems, List<Deal> deals) {
        int[] cost = new int[numberOfItems + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        for (int i = 0; i < numberOfItems - 1; i++) {
            for (Deal deal : deals) {
                if (cost[deal.source] == Integer.MAX_VALUE)
                    continue;
                if (cost[deal.source] + deal.cost >= cost[deal.target])
                    continue;
                cost[deal.target] = cost[deal.source] + deal.cost;
            }
        }
        for (Deal deal : deals) {
            if (cost[deal.source] != Integer.MAX_VALUE && cost[deal.source] + deal.cost < cost[deal.target])
                return true;
        }
        return false;
    }
}

class Deal {
    int source;
    int target;
    int cost;

    public Deal(int source, int target, int cost) {
        this.source = source;
        this.target = target;
        this.cost = cost;
    }
}
