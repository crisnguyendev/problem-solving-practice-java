package DSA.TwoHeap.SlidingWindowMedian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[][] arr = {{2147483647, 2147483647}};
        int[] k = {2};
        Solution solution = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array = " + Arrays.toString(arr[i]) + ", k = " + k[i]);
            double[] output = solution.medianSlidingWindow(arr[i], k[i]);
            System.out.println("\tMedians = " + Arrays.toString(output));
        }
    }
}

class Solution {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private Map<Integer, Integer> removedNums;
    int leftSize = 0;
    int rightSize = 0;
    double lastMedian = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] medians = new double[n - k + 1];
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                medians[i] = nums[i];
            }
            return medians;
        }
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
        removedNums = new HashMap<>();
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            minHeap.add(maxHeap.poll());
            rightSize++;
        }
        leftSize = k - rightSize;
        lastMedian = k % 2 == 0 ? maxHeap.peek() / 2.0 + minHeap.peek() / 2.0 : maxHeap.peek();
        medians[0] = lastMedian;

        for (int i = 0; i < n - k; i++) {
            int outNum = nums[i];
            int inNum = nums[i + k];
            medians[i + 1] = getMedian(outNum, inNum);
        }

        return medians;
    }

    private double getMedian(int outNum, int inNum) {
        if (outNum == inNum)
            return lastMedian;
        removeNumFromWindow(outNum);
        addNumToWindow(inNum);
        if (leftSize > rightSize) {
            lastMedian = maxHeap.peek();
        } else if (leftSize < rightSize) {
            lastMedian = minHeap.peek();
        } else {
            lastMedian = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return lastMedian;
    }

    private void addNumToWindow(int inNum) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= inNum) {
            maxHeap.add(inNum);
            leftSize++;
        } else {
            minHeap.add(inNum);
            rightSize++;
        }
        balanceHeaps();
    }

    private void removeNumFromWindow(int outNum) {
        if (outNum == maxHeap.peek()) {
            maxHeap.poll();
            leftSize--;
            refineHeapWithRemovedNumbers(maxHeap, leftSize);
        } else if (outNum == minHeap.peek()) {
            minHeap.poll();
            rightSize--;
            refineHeapWithRemovedNumbers(minHeap, rightSize);
        } else {
            if (outNum < maxHeap.peek()) {
                leftSize--;
            } else if (outNum > minHeap.peek()) {
                rightSize--;
            }
            int count = removedNums.get(outNum) == null ? 0 : removedNums.get(outNum);
            count++;
            removedNums.put(outNum, count);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        if (leftSize - rightSize > 1) {
            minHeap.add(maxHeap.poll());
            leftSize--;
            rightSize++;
            refineHeapWithRemovedNumbers(maxHeap, leftSize);
        } else if (rightSize - leftSize > 1) {
            maxHeap.add(minHeap.poll());
            rightSize--;
            leftSize++;
            refineHeapWithRemovedNumbers(minHeap, rightSize);
        } else if (leftSize == rightSize && maxHeap.peek() > minHeap.peek()) {
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
    }

    private void refineHeapWithRemovedNumbers(PriorityQueue<Integer> heap, int size) {
        while (!heap.isEmpty() && removedNums.get(heap.peek()) != null) {
            int top = heap.poll();
            size--;
            int count = removedNums.get(top);
            count--;
            if (count == 0) {
                removedNums.remove(top);
            } else {
                removedNums.put(top, count);
            }
        }
    }
}