package DSA.Heap.AddAll;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AddAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n < 2)
                break;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                minHeap.add(scanner.nextInt());
            }
            long totalCost = 0;
            while (minHeap.size() > 1) {
                int a = minHeap.poll();
                int b = minHeap.poll();
                totalCost += a + b;
                minHeap.add(a + b);
            }
            System.out.println(totalCost);
            minHeap.poll();
        }
    }
}
