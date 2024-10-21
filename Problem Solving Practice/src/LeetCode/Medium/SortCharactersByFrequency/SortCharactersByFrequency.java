package LeetCode.Medium.SortCharactersByFrequency;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        int[] frequency = new int[256];
        PriorityQueue<CharFrequency> maxHeap = new PriorityQueue<>(Comparator.comparingInt(CharFrequency::getFrequency).reversed());
        for (char c : s.toCharArray()) {
            frequency[c]++;
        }
        for (int i = 0; i < 256; i++) {
            maxHeap.add(new CharFrequency((char) (i), frequency[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharFrequency cf = maxHeap.poll();
            sb.append(String.valueOf(cf.c).repeat(cf.getFrequency()));
        }
        return sb.toString();
    }
}

class CharFrequency {
    char c;
    int frequency;

    public CharFrequency(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(new Solution().frequencySort(s));
    }
}
