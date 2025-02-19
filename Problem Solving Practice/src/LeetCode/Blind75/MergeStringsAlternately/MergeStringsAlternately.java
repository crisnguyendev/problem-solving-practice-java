package LeetCode.Blind75.MergeStringsAlternately;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.print(new Solution().mergeAlternately(word1, word2));
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        while(p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }
        while(p1 < word1.length()) {
            sb.append(word1.charAt(p1));
            p1++;
        }
        while(p2 < word2.length()) {
            sb.append(word2.charAt(p2));
            p2++;
        }

        return sb.toString();
    }
}