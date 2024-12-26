package DSA.TopKthElements.KthLargestElementInStream;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
}

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (minHeap.size() == k) {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }

        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */