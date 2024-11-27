package DSA.SlidingWindow.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = n + 1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == n + 1 ? 0 : minLength;
    }
}
