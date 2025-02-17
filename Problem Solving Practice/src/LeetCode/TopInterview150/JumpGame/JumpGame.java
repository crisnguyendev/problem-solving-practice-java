package LeetCode.TopInterview150.JumpGame;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution().canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int position = 0;
        int nextPosition = nums[0];
        while (position < nextPosition && nextPosition <= nums.length - 1) {
            position++;
            if (position + nums[position] > nextPosition) {
                nextPosition = position + nums[position];
            }
        }
        return nextPosition >= nums.length - 1;
    }
}
