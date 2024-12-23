package DSA.TwoPointers.MoveZeroes;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new Solution().moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (j == -1)
                    j = i + 1;
                for (; j < n; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}