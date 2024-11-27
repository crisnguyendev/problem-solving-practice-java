package DSA.SlidingWindow.MinimumWindowSubsequence;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl";
        String s2 = "u";
        System.out.print(new Solution().minWindow(s1, s2));
    }
}

class Solution {
    // Time complexity: O(n^2)
    // Space complexity: O(n) -> Trade off between time and space. If we do not use array to store chars -> Space complexity could be O(1), it would be slower a little bit.

    public String minWindow(String s1, String s2) {
        String result = "";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;

        int i1 = 0;
        int i2 = 0;
        int shortestSubstring = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        while (i1 < length1) {
            if (chars1[i1] == chars2[i2]) {
                i2++;
            }
            i1++;
            if (i2 == length2) {
                i1--;
                i2--;
                int tempEnd = i1;
                while (i2 >= 0) {
                    if (chars1[i1] == chars2[i2]) {
                        i2--;
                    }
                    i1--;
                }
                i1++;
                i2++;
                if (tempEnd - i1 + 1 < shortestSubstring) {
                    shortestSubstring = tempEnd - i1 + 1;
                    start = i1;
                    end = tempEnd;
                }
                i1++;
            }
        }
        return end == -1 ? "" : s1.substring(start, start + shortestSubstring);
    }
}