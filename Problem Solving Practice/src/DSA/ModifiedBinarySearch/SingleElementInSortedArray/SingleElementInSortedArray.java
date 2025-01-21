package DSA.ModifiedBinarySearch.SingleElementInSortedArray;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 1, 1};
        System.out.print(new Solution().singleNonDuplicate(nums));
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if (mid % 2 != 0) {
                mid--;
            }
            if(nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}