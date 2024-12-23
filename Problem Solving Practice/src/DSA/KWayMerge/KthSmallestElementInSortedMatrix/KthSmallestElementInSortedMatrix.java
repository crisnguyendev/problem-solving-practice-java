package DSA.KWayMerge.KthSmallestElementInSortedMatrix;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // {col, data}
        return 0;
    }
}