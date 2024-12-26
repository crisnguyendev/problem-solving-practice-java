package DSA.TopKthElements.TopKFrequentElement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (entry.getValue() > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            }

        }
        int i = 0;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            result[i] = top[0];
            i++;
        }
        return result;
    }
}

class OptimalSolution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] counts = new int[200001];
        int base = 10000;
        for (int num : nums) {
            counts[num + base]++;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i <= 100000; i++) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{i, counts[i]});
            } else if (counts[i] > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.add(new int[]{i, counts[i]});
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            int[] val = minHeap.poll();
            result[i] = val[0] - base;
            i++;
        }
        return result;
    }
}