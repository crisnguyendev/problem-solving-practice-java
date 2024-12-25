package DSA.KWayMerge.KthSmallestNumberInMSortedList;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberInMSortedList {
}


class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        int n = lists.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // {row, value}
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[]{i, lists.get(i).get(0)});
        }
        int[] pointers = new int[n];
        int m = 1;
        while (!minHeap.isEmpty() && m < k) {
            int[] top = minHeap.poll();
            int row = top[0];
            if (pointers[row] < lists.get(row).size() - 1) {
                pointers[row]++;
                minHeap.add(new int[]{row, lists.get(row).get(pointers[row])});
            }
            m++;
        }
        return minHeap.poll()[1];
    }
}