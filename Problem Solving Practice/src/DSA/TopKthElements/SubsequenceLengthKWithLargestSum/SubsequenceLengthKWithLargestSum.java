package DSA.TopKthElements.SubsequenceLengthKWithLargestSum;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SubsequenceLengthKWithLargestSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, 3, 4};
        int k = 3;
        System.out.print(Arrays.toString(new Solution().maxSubsequence(nums, k)));
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        boolean[] inResult = new boolean[n];
        int[] result = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            minHeap.add(new int[]{nums[i], i});
            inResult[i] = true;
        }
        for (int i = k; i < n; i++) {
            int num = nums[i];
            if (!minHeap.isEmpty() && num > minHeap.peek()[0]) {
                int[] top = minHeap.poll();
                minHeap.add(new int[]{num, i});
                inResult[i] = true;
                inResult[top[1]] = false;
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (inResult[i]) {
                result[j] = nums[i];
                j++;
            }
        }
        return result;
    }
}