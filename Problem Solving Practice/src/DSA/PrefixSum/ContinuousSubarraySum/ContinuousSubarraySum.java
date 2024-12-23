package DSA.PrefixSum.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0};
        int k = 3;
        System.out.print(new Solution().checkSubarraySum(nums, k));
    }
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int prefixSum = nums[0];
        remainderMap.put(prefixSum % k, 0);
        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum % k;
            if (remainder == 0)
                return true;
            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1)
                    return true;
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }
}