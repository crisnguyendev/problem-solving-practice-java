package LeetCode.Medium.MinCostConnectAllPoints;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private int[] parent;
    private int treeHeight = 0;

    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int n = points.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int manhattanDistance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.add(new int[]{manhattanDistance, i, j});
            }
        }
        int minCost = 0;
        while (!minHeap.isEmpty() && treeHeight < n - 1) {
            int[] edge = minHeap.poll();
            if (unionSet(edge[1], edge[2])) {
                minCost += edge[0];
            }
        }
        return minCost;
    }

    private int findSet(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findSet(parent[x]);
    }

    private boolean unionSet(int x, int y) {
        int xRoot = findSet(x);
        int yRoot = findSet(y);
        if (xRoot == yRoot)
            return false;
        parent[xRoot] = yRoot;
        treeHeight++;
        return true;
    }
}


public class MinCostConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new Solution().minCostConnectPoints(points));
    }
}
