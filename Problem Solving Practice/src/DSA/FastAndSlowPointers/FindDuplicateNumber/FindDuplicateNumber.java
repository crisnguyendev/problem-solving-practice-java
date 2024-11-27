package DSA.FastAndSlowPointers.FindDuplicateNumber;

public class FindDuplicateNumber {

}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)

    public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[0];
        do {
            s = nums[s];
            f = nums[nums[f]];
        } while (s != f);
        s = nums[0];
        while(s != f) {
            s = nums[s];
            f = nums[f];
        }
        return f;
    }
}