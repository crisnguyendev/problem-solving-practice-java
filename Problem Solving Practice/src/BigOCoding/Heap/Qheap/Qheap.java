package BigOCoding.Heap.Qheap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> removedHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int action = scanner.nextInt();
            if (action == 1) {
                heap.add(scanner.nextInt());
            } else if (action == 2) {
                removedHeap.add(scanner.nextInt());
            } else if (action == 3) {
                while (!removedHeap.isEmpty() && (int) heap.peek() == (int) removedHeap.peek()) {
                    heap.remove();
                    removedHeap.remove();
                }
                System.out.println(heap.peek());
            }
        }
    }
}
