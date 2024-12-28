package DSA.TopKthElements.ThirdMaximumNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 5, 3, 5};
        System.out.print(new Solution().thirdMax(nums));
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        int k = 3;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        int j = 0;
        while (i < k && j < n) {
            int num = nums[j];
            if (!set.contains(num)) {
                minHeap.add(num);
                i++;
            }
            set.add(num);
            j++;
        }

        for (int l = k; l < n; l++) {
            int num = nums[l];
            if (!set.contains(num) && !minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
            set.add(num);
        }
        if (minHeap.size() < 3) {
            int result = -1;
            while (!minHeap.isEmpty()) {
                result = minHeap.poll();
            }
            return result;
        } else {
            return minHeap.peek();
        }
    }
}