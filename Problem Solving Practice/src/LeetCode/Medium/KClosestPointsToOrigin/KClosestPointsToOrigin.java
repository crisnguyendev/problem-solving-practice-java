package LeetCode.Medium.KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Point> minHeap = new PriorityQueue<>();
        for (int[] point : points) {
            minHeap.add(new Point(point[0], point[1]));
        }
        int i = 0;
        Point min;
        while (!minHeap.isEmpty() && i < k) {
            min = minHeap.poll();
            result[i][0] = min.x;
            result[i][1] = min.y;
            i++;
        }
        return result;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }

    @Override
    public int compareTo(Point o) {
        return this.distance - o.distance;
    }
}


public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        System.out.println(Arrays.deepToString(new Solution().kClosest(points, k)));
    }

}
