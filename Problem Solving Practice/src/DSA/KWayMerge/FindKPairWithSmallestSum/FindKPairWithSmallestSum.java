package DSA.KWayMerge.FindKPairWithSmallestSum;

import java.util.*;

public class FindKPairWithSmallestSum {
}

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n1 = nums1.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n1 && i < k; i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        int counter = 1;

        while (!minHeap.isEmpty() && counter <= k) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];
            result.add(List.of(nums1[i], nums2[j]));
            int nextIndex2 = j + 1;
            if (nums2.length > nextIndex2) {
                minHeap.add(new int[]{nums1[i] + nums2[nextIndex2], i, nextIndex2});
            }
            counter++;
        }
        return result;
    }
}