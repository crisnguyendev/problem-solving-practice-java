package DSA.SlidingWindow.MaximumAverageSubarrayI;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(new Solution().findMaxAverage(nums, k));
    }
}


class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            if (sum > max)
                max = sum;
        }
        return max / k;
    }
}