package DSA.TopKthElements.ReorganizeString;

import java.util.PriorityQueue;

public class ReorganizeString {
}

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        char[] chars = s.toCharArray();
        int[] charFreq = new int[26];
        int maxFreq = 0;
        for (char c : chars) {
            int ch = c - 'a';
            charFreq[ch]++;
            maxFreq = Math.max(maxFreq, charFreq[ch]);
        }
        if (maxFreq > (n + 1) / 2)
            return "";

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > 0) {
                maxHeap.add(new int[]{'a' + i, charFreq[i]});
            }
        }

        int[] prev = null;
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            sb.append((char) top[0]);
            top[1]--;
            if (prev != null) {
                maxHeap.add(prev);
                prev = null;
            }
            if (top[1] != 0) {
                prev = top;
            }
        }
        return sb.toString();
    }
}