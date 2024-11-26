package DSA.Heap.Promotion;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Promotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_ID = (int) 1e6 + 5;
        boolean[] removed = new boolean[MAX_ID];
        int n = scanner.nextInt();
        PriorityQueue<Bill> minHeap = new PriorityQueue<>();
        PriorityQueue<Bill> maxHeap = new PriorityQueue<>(new Comparator<Bill>() {
            @Override
            public int compare(Bill bill1, Bill bill2) {
                return bill2.compareTo(bill1);
            }
        });
        long totalCost = 0;
        int id = 1;
        for (int i = 1; i <= n; i++) {
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                Bill bill = new Bill(id, scanner.nextInt());
                id++;
                minHeap.add(bill);
                maxHeap.add(bill);
            }
            Bill maxBill = null;
            Bill minBill = null;
            while (!maxHeap.isEmpty()) {
                maxBill = maxHeap.poll();
                if (!removed[maxBill.id])
                    break;
            }

            while (!minHeap.isEmpty()) {
                minBill = minHeap.poll();
                if (!removed[minBill.id])
                    break;
            }
            if (maxBill != null && minBill != null) {
                int x = maxBill.cost - minBill.cost;
                removed[minBill.id] = true;
                removed[maxBill.id] = true;
                totalCost += x;
            }
        }
        System.out.println(totalCost);

    }


}

class Bill implements Comparable<Bill> {
    int id;
    int cost;

    public Bill(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bill bill) {
        return this.cost - bill.cost;
    }
}
