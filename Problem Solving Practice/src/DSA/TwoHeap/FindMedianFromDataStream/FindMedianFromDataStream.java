package DSA.TwoHeap.FindMedianFromDataStream;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        // Driver code
        int[] nums = {1, 2, 3};
        MedianFinder medianOfAges = null;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianFinder();
            for (int j = 0; j <= i; j++) {
                System.out.print(nums[j]);
                if (j != i)
                    System.out.print(", ");
                medianOfAges.addNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
        }

    }
}

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}
