package DSA.PrefixSum.MinimumValueGetPositiveStepByStepSum;

public class MinimumValueGetPositiveStepByStepSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, -3};
        System.out.print(new Solution().minStartValue(nums));
    }
}

class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = nums[0];
        int min = 1 - prefixSum;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            prefixSum += nums[i];
            min = Math.max(1 - prefixSum, min);
        }
        return Math.max(min, 1);
    }
}