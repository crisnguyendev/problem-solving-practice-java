package DSA.TwoPointers.SortColors;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
