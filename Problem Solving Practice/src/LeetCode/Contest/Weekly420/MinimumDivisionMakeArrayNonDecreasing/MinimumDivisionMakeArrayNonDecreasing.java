package LeetCode.Contest.Weekly420.MinimumDivisionMakeArrayNonDecreasing;


class Solution {
    public int minOperations(int[] nums) {
        int last = nums[nums.length - 1];
        int count = 0;
        int gpd = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            while (nums[i] > last) {
                gpd = greatestProperDivisor(nums[i]);
                nums[i] = nums[i] / gpd;
                if (gpd == 1 && nums[i] > last)
                    return -1;
                count++;
            }
            last = nums[i];
        }
        return count;
    }

    public int greatestProperDivisor(int n) {
        if (n < 2) {
            return -1;
        }
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }
}

public class MinimumDivisionMakeArrayNonDecreasing {
    public static void main(String[] args) {
        int[] nums = {5, 3, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(nums));
    }
}

