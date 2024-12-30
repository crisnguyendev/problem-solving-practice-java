package DSA.ModifiedBinarySearch.RandomPickWeight;

import java.util.Random;

public class RandomPickWeight {
}

class Solution {
    Random random;
    int[] prefixSum;
    int size;

    public Solution(int[] w) {
        size = w.length;
        this.random = new Random();
        prefixSum = new int[size];
        prefixSum[0] = w[0];
        for (int i = 1; i < size; ++i)
            prefixSum[i] += prefixSum[i - 1] + w[i];
    }

    public int pickIndex() {
        int index = random.nextInt(prefixSum[size - 1]) + 1;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] == index)
                return mid;
            else if (prefixSum[mid] < index)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */