package LeetCode.Medium.RedundantConnection;

import java.util.Arrays;

class Solution {
    private int[] parents;
    int[] result = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (unionSet(edge[0], edge[1]))
                break;
        }

        return result;
    }

    private int findSet(int x) {
        if (x == parents[x]) {
            return x;
        }
        return findSet(parents[x]);
    }

    private boolean unionSet(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        if (rootX == rootY) {
            result[0] = x;
            result[1] = y;
            return true;
        }
        parents[rootY] = rootX;
        return false;
    }
}

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}
