package DSA.BinarySearchTree.MinimumLoss;

import java.util.Scanner;
import java.util.TreeSet;

public class MinimumLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Long> prices = new TreeSet<Long>();
        int totalYears = scanner.nextInt();
        Long minimumLoss = Long.MAX_VALUE;
        for (int i = 0; i < totalYears; i++) {
            long sellPrice = scanner.nextLong();
            if (!prices.isEmpty() && prices.last() > sellPrice) {
                long loss = prices.higher(sellPrice) - sellPrice;
                if (loss < minimumLoss) {
                    minimumLoss = loss;
                }
            }
            prices.add(sellPrice);
        }
        System.out.println(minimumLoss);
    }
}
