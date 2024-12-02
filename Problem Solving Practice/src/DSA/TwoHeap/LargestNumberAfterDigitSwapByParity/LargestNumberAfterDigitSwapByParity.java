package DSA.TwoHeap.LargestNumberAfterDigitSwapByParity;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapByParity {
    public static void main(String[] args) {
        int[] testCases = {1234, 65875, 4321, 2468, 98123};
        Solution solution = new Solution();
        for (int num : testCases) {
            System.out.println("\tInput number: " + num);
            System.out.println("\tOutput number: " + solution.largestInteger(num));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class Solution {
    public int largestInteger(int num) {
        String numStr = Integer.toString(num);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int d : digits) {
            if (d % 2 == 0) {
                evenMaxHeap.add(d);
            } else {
                oddMaxHeap.add(d);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int d : digits) {
            if (d % 2 == 0) {
                result.append(evenMaxHeap.poll());
            } else {
                result.append(oddMaxHeap.poll());
            }
        }

        return Integer.parseInt(result.toString());
    }
}