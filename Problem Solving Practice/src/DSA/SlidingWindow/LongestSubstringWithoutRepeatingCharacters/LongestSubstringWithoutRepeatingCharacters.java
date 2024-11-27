package DSA.SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcdbea";
        System.out.print(new Solution().lengthOfLongestSubstring(s));
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int start = 0;
        int[] charIndex = new int[128];
        for (int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }
        for (int end = 0; end < length; end++) {
            char currentChar = chars[end];
            if (charIndex[currentChar] >= start) {
                start = charIndex[currentChar] + 1;
            }
            charIndex[currentChar] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}