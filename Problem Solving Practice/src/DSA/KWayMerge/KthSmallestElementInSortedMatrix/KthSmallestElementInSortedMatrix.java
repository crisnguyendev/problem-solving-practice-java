package DSA.KWayMerge.KthSmallestElementInSortedMatrix;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{-5}};

        int k = 1;
        System.out.print(new Solution().kthSmallest(matrix, k));
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // {row, value}
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[]{i, matrix[i][0]});
        }
        int[] pointers = new int[n];
        int m = 1;
        while (!minHeap.isEmpty() && m < k) {
            int[] top = minHeap.poll();
            int row = top[0];
            if (pointers[row] < n - 1) {
                pointers[row]++;
                minHeap.add(new int[]{row, matrix[row][pointers[row]]});
            }
            m++;
        }
        return minHeap.poll()[1];
    }
}