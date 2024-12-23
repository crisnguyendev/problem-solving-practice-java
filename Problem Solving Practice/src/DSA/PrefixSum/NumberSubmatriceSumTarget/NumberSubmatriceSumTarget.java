package DSA.PrefixSum.NumberSubmatriceSumTarget;

import java.util.HashMap;
import java.util.Map;

public class NumberSubmatriceSumTarget {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int target = 4;
        System.out.print(new Solution().numSubmatrixSumTarget(matrix, target));
    }
}

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] prefixSum = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int count = 0;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int c1 = 1; c1 < columns + 1; c1++) {
            for (int c2 = c1; c2 < columns + 1; c2++) {
                map.clear();
                map.put(0, 1);
                for (int row = 1; row < rows + 1; row++) {
                    cur = prefixSum[row][c2] - prefixSum[row][c1 - 1];
                    count += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return count;
    }
}