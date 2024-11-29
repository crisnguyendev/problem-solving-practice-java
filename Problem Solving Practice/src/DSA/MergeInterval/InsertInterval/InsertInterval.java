package DSA.MergeInterval.InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = new Solution().insert(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedList = new ArrayList<>();
        int index = 0;
        int n = intervals.length;
        while (index < n && intervals[index][1] < newInterval[0]) {
            mergedList.add(intervals[index]);
            index++;
        }
        if (index < n) {
            int start = Math.min(intervals[index][0], newInterval[0]);
            int end = newInterval[1];
            while (index < n && end >= intervals[index][0]) {
                end = Math.max(end, intervals[index][1]);
                ++index;
            }
            mergedList.add(new int[]{start, end});
        } else {
            mergedList.add(newInterval);
        }
        while (index < n) {
            mergedList.add(intervals[index]);
            index++;
        }
        int resultSize = mergedList.size();
        int[][] result = new int[resultSize][];
        int i = 0;
        for(int[] interval: mergedList) {
            result[i] =interval;
            i++;
        }
        return result;
    }
}