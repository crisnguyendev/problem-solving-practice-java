package LeetCode.TwoPointers.MinimumNumberMoveMakePalindrome;

public class MinimumNumberMoveMakePalindrome {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution().minMovesToMakePalindrome(s));
    }
}

class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] chars = s.toCharArray();
        int moves = 0;
        int i = 0, j = chars.length - 1;
        while (i < j) {
            int k = j;
            while (k > i && chars[i] != chars[k]) {
                k--;
            }

            if (k == i) {
                moves += chars.length / 2 - i;
            } else {
                while (k < j) {
                    char temp = chars[k];
                    chars[k] = chars[k + 1];
                    chars[k + 1] = temp;
                    k++;
                    moves++;
                }
                j--;
            }
            i++;
        }
        return moves;
    }
}