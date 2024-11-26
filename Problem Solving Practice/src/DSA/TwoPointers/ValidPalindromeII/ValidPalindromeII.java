package DSA.TwoPointers.ValidPalindromeII;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(new Solution().isPalindrome(s));
    }
}

class Solution {
    public boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left <= right) {
            if (string.charAt(left) == string.charAt(right)) {
                left++;
                right--;
            } else
                return isPalindrome(string, left + 1, right) || isPalindrome(string, left, right - 1);
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }
}
