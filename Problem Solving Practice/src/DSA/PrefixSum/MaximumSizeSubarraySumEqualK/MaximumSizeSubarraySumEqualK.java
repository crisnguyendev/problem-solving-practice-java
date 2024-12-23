package DSA.PrefixSum.MaximumSizeSubarraySumEqualK;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0};
        int k = 1;
        System.out.print(new Solution().maxSubArrayLen(nums, k));
    }
}

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int m = prefixSum - k;
            if (m == 0) {
                maxLength = i + 1;
            }
            if (map.containsKey(m)) {
                maxLength = Math.max(i - map.get(m), maxLength);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}