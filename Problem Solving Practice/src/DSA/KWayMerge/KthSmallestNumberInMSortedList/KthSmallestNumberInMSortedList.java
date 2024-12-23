package DSA.KWayMerge.KthSmallestNumberInMSortedList;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberInMSortedList {
}


class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int count = 0;
        int n = lists.size();
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[]{i, lists.get(i).get(0)});
        }
        while(count < k ) {
            int[] top =  minHeap.poll();

        }
        // Replace this placeholder return statement with your code

        return 0;
    }
}