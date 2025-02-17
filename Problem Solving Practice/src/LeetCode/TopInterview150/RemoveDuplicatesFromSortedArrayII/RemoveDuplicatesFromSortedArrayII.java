package LeetCode.TopInterview150.RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length <= 2)
            return nums.length;
        int k = 0;
        int exist = 1;
        int currentNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNumber && exist < 2) {
                exist++;
                k++;
            } else if (nums[i] != currentNumber) {
                currentNumber = nums[i];
                exist = 1;
                k++;
            }
            nums[k] = nums[i];
        }
        return k + 1;
    }
}
