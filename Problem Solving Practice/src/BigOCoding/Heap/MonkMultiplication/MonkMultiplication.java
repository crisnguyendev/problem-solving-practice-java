package BigOCoding.Heap.MonkMultiplication;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MonkMultiplication {
    private static int n;
    private static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < n; i++) {
            priorityQueue.add(scanner.nextInt());
            processQueue();
        }
    }

    private static void processQueue() {
        if (priorityQueue.size() < 3) {
            System.out.println(-1);
            return;
        }
        int first = priorityQueue.poll();
        int second = priorityQueue.poll();
        int third = priorityQueue.poll();
        long product = (long) first * second * third;
        System.out.println(product);
        priorityQueue.add(first);
        priorityQueue.add(second);
        priorityQueue.add(third);
    }
}
