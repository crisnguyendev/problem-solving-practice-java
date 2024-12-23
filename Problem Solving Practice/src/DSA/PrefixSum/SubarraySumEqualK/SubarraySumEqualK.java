package DSA.PrefixSum.SubarraySumEqualK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;
        System.out.print(new Solution().subarraySum(nums, k));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}