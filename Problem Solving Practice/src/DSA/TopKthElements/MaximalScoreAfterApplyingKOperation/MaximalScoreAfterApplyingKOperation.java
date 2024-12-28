package DSA.TopKthElements.MaximalScoreAfterApplyingKOperation;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 3, 3, 3};
        int k = 3;
        System.out.print(new Solution().maxKelements(nums, k));
    }
}

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }
        long score = 0;
        for (int i = 0; i < k; i++) {
            int top = maxHeap.poll();
            if (top == 1) {
                return score + k - i;
            }
            score = score + top;
            int reduced = (top + 2) / 3;
            maxHeap.add(reduced);
        }
        return score;
    }
}