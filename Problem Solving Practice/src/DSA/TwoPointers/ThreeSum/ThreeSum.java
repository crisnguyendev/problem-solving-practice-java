package DSA.TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}

class Solution {

    // Time complexity: O(nlog(n)+n^2) = O(n^2)
    // Space complexity: O(log(n))

    public List<List<Integer>> threeSum(int[] nums) {
        int TARGET = 0;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n - 2; first++) {
            if(nums[first] > TARGET)
                break;
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int right = n - 1;
            int left = first + 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[first];
                if (sum == TARGET) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[first]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > TARGET) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}