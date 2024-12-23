package DSA.PrefixSum.FindPivotIndex;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.print(new Solution().pivotIndex(nums));
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : prefixSum[i - 1];
            int right = i == n - 1 ? 0 : prefixSum[n - 1] - prefixSum[i];
            if (left == right)
                return i;
        }
        return -1;
    }
}