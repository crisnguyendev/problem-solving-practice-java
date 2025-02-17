package LeetCode.Blind75.MaximumNumberVowelsInSubstringGivenLength;

public class MaximumNumberVowelsInSubstringGivenLength {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(new Solution().maxVowels(s, k));
    }
}

class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += countVowel(s.charAt(i));
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            count += countVowel(s.charAt(i));
            count -= countVowel(s.charAt(i - k));
            max = Math.max(max, count);
        }
        return max;
    }

    private int countVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return 1;
        return 0;
    }
}