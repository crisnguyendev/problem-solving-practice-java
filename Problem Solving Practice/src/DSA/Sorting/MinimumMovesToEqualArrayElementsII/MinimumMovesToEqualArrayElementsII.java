package DSA.Sorting.MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] arg) {
        int[] nums = new int[]{1, 2, 3};
        System.out.print(new Solution().minMoves2(nums));
    }
}

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int median = nums[nums.length / 2];
        for(int num : nums) {
            result = result + Math.abs(num - median);
        }
        return result;
    }
}