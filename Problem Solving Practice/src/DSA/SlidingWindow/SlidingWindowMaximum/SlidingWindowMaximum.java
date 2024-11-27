package DSA.SlidingWindow.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
    }
}

class Solution {
    // Time: O(n)
    // Space: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!window.isEmpty() && nums[window.getLast()] <= nums[i]) {
                window.removeLast();
            }
            window.add(i);
        }
        result[0] = nums[window.getFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!window.isEmpty() && nums[i] >= nums[window.getLast()]) {
                window.removeLast();
            }
            if (!window.isEmpty() && window.getFirst() <= (i - k)) {
                window.removeFirst();
            }
            window.add(i);
            result[i - k + 1] = nums[window.getFirst()];
        }

        return result;
    }
}

class OptimalSolution {
    // Time: O(n)
    // Space: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left_max[] = new int[nums.length];
        int right_max[] = new int[nums.length];
        int ans[] = new int[nums.length - k + 1];
        for (int start = 0; start < nums.length; start += k) {
            int end = Math.min(start + k - 1, nums.length - 1);
            for (int i = start, max = Integer.MIN_VALUE; i <= end; i++) {
                max = Math.max(max, nums[i]);
                left_max[i] = max;
            }
            for (int i = end, max = Integer.MIN_VALUE; i >= start; i--) {
                max = Math.max(max, nums[i]);
                right_max[i] = max;
            }
            for (int i = 0; i <= nums.length - k; i++) {
                ans[i] = Math.max(left_max[i + k - 1], right_max[i]);
            }
        }
        return ans;
    }
}