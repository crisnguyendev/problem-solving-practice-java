package DSA.TwoHeap.FindRightInterval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{1, 12}, {2, 9}, {3, 10}, {13, 14}, {15, 16}, {16, 17}}
        };

        Solution solution = new Solution();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + "\tintervals: " + Arrays.deepToString(testCases[i]));
            int[] result = solution.findRightInterval(testCases[i]);
            System.out.println("\n\tOutput: " + Arrays.toString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class Interval {
    int index;
    int start;
    int end;

    public Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int size = intervals.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = -1;
        }

        PriorityQueue<Interval> startMinHeap = new PriorityQueue<>((a, b) -> a.start - b.start);
        PriorityQueue<Interval> endMinHeap = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (int i = 0; i < size; i++) {
            Interval interval = new Interval(i, intervals[i][0], intervals[i][1]);
            startMinHeap.add(interval);
            endMinHeap.add(interval);
        }

        while (!endMinHeap.isEmpty()) {
            Interval earliestEndInterval = endMinHeap.poll();
            while (!startMinHeap.isEmpty() && earliestEndInterval.end > startMinHeap.peek().start) {
                startMinHeap.poll();
            }
            if (!startMinHeap.isEmpty()) {
                result[earliestEndInterval.index] = startMinHeap.peek().index;
            }
        }

        return result;
    }
}
