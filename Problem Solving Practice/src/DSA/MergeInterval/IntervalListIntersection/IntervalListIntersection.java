package DSA.MergeInterval.IntervalListIntersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String args[]) {
        int[][][] inputIntervalLista = {
                {{1, 2}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{1, 2}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(new Solution().intervalIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class Solution {
    //Time Complexity: O(m + n)
    // Space Complexity: O(m + n)

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int index1 = 0;
        int index2 = 0;
        int m = firstList.length;
        int n = secondList.length;
        if (m == 0 || n == 0) {
            return new int[][]{};
        }
        List<int[]> ans = new ArrayList<>();
        while (index1 < m && index2 < n) {
            int[] first = firstList[index1];
            int[] second = secondList[index2];
            int[] intersection = findIntersection(first, second);
            if (intersection != null) {
                ans.add(intersection);
            }
            if (first[1] < second[1]) {
                index1++;
            } else {
                index2++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    private int[] findIntersection(int[] first, int[] second) {
        if (first[1] > second[0] && first[0] <= second[1] || second[1] > first[0] && second[0] <= first[1]) {
            return new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])};
        } else {
            return null;
        }
    }
}