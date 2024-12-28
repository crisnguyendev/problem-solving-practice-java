package DSA.TopKthElements.MinimumCostHireKWorker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostHireKWorker {
    public static void main(String[] args) {
        int[] quality = new int[]{10, 20, 5};
        int[] wage = new int[]{70, 50, 30};
        int k = 2;
        System.out.print(new Solution().mincostToHireWorkers(quality, wage, k));
    }
}

class WorkerRatio {
    double ratio;
    int quality;
    WorkerRatio(double ratio, int quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        WorkerRatio[] ratio = new WorkerRatio[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = new WorkerRatio((double) wage[i] / quality[i], quality[i]);
        }
        Arrays.sort(ratio, Comparator.comparingDouble(a -> a.ratio));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sumQuality = 0;
        for (int i = 0; i < k; i++) {
            pq.add(ratio[i].quality);
            sumQuality += ratio[i].quality;
        }
        double baseRatio = ratio[k - 1].ratio;
        double ans = baseRatio * sumQuality;
        for (int i = k; i < n; i++) {
            double newRatio = ratio[i].ratio;
            int currentQuality = ratio[i].quality;
            if (pq.peek() > currentQuality) {
                sumQuality -= pq.poll();
                pq.add(currentQuality);
                sumQuality += currentQuality;
            }
            ans = Math.min(ans, newRatio * sumQuality);
        }
        return ans;
    }
}