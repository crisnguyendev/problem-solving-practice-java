package MIU.Assignment.Lab11.Question01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildHeapTopDown {
    private static List<Integer> heap;

    public static void main(String[] args) {
        heap = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(pushToMinHeap(scanner.nextInt()));
        }
        System.out.println(heap);
    }

    public static int pushToMinHeap(int value) {
        heap.add(value);
        int i = heap.size() - 1;
        int count = 0;
        while (i != 0 && heap.get((i - 1) / 2) > heap.get(i)) {
            count++;
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        return count;
    }

    private static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


}
