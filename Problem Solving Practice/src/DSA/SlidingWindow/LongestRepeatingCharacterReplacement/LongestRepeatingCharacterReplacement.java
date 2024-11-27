package DSA.SlidingWindow.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.print(new Solution().characterReplacement(s, k));
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)

    public int characterReplacement(String s, int k) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int[] freq = new int[26];
        int maxLength = 0;
        int mostFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[charArray[right] - 'A']++;
            mostFreq = Math.max(mostFreq, freq[charArray[right] - 'A']);
            while (right - left + 1 > mostFreq + k) {
                freq[charArray[left] - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}