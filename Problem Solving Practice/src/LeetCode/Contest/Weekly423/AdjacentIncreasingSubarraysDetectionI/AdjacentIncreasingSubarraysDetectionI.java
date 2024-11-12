package LeetCode.Contest.Weekly423.AdjacentIncreasingSubarraysDetectionI;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> input = List.of(6, 13, -17, -20, 2);
        int k = 2;
        System.out.println(new Solution().hasIncreasingSubarrays(input, k));
    }
}

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int left = 1;
        int right = 1;
        int start = 0;
        while (true) {
            if (left < k) {
                start++;
                if (nums.get(start) > nums.get(start - 1)) {
                    left++;
                } else {
                    left = 1;
                }
            }
            if(right < k){

            }
        }
    }
}
