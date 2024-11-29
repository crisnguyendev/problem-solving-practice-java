package DSA.MergeInterval.MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeInterval {
    public static void main(String[] args) {
        int[][][] allIntervals = {
                {{1, 5}, {3, 7}, {4, 6}},
                {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
                {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {3, 8}, {4, 4}},
                {{1, 2}, {3, 4}, {8, 8}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        int index = 1;
        Solution solution = new Solution();
        for (int[][] intervals : allIntervals) {
            System.out.println(index + ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = solution.merge(intervals);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            index++;
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            minHeap.add(interval);
        }
        List<int[]> list = new ArrayList<>();
        int[] current = minHeap.poll();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            if (current[1] < top[0]) {
                list.add(current);
                current = top;
            } else {
                current[1] = Math.max(current[1], top[1]);
            }
        }
        list.add(current);
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] item : list) {
            result[index] = item;
            index++;
        }
        return result;
    }
}