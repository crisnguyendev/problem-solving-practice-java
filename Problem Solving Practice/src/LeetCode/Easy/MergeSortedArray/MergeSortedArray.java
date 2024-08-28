package LeetCode.Easy.MergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of nums1 and nums2
        int i = m - 1;  // Last element in the first part of nums1
        int j = n - 1;  // Last element in nums2
        int k = m + n - 1;  // Last position in nums1

        // Merge nums1 and nums2, starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, add them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

}
