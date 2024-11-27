package DSA.SlidingWindow.MinimumWindowSubstring;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ABDFGDCKAB";
        String t = "ABCD";
        System.out.print(new Solution().minWindow(s, t));
    }
}

class Solution {
    // Time complexity: O(m + n)
    // Space complexity: O(m)
    public String minWindow(String s, String t) {
        int[] freqT = new int[72];
        int[] freqW = new int[72];
        char[] charsT = t.toCharArray();
        char[] charsS = s.toCharArray();
        int lengthS = s.length();
        int lengthT = t.length();

        int shortestLength = Integer.MAX_VALUE;
        for (int i = 0; i < lengthT; i++) {
            freqT[charsT[i] - 'A']++;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int shortestStart = -1;
        while (end < lengthS) {
            int charEnd = charsS[end] - 'A';
            if (freqT[charEnd] > 0) {
                if (freqT[charEnd] > freqW[charEnd]) {
                    count++;
                }
                freqW[charEnd]++;
            }

            if (count == lengthT) {
                while (start <= end) {
                    int charStart = charsS[start] - 'A';
                    if (freqT[charStart] > 0 && freqT[charStart] <= freqW[charStart]) {
                        freqW[charStart]--;
                        if (freqW[charStart] < freqT[charStart]) {
                            count--;
                            break;
                        }
                    }
                    start++;
                }
                if (shortestLength > end - start + 1) {
                    shortestStart = start;
                    shortestLength = end - start + 1;
                }
                start++;
            }
            end++;
        }
        return shortestStart == -1 ? "" : s.substring(shortestStart, shortestStart + shortestLength);
    }
}