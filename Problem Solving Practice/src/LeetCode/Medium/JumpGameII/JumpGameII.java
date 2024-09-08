package LeetCode.Medium.JumpGameII;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
    }
}

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;

        while (currentEnd < n - 1) {
            jumps++;
            while (i <= currentEnd) {
                farthest = Math.max(farthest, i + nums[i]);
                i++;
            }
            currentEnd = farthest;
            if (currentEnd >= n - 1) break;
        }
        return jumps;
    }
}
