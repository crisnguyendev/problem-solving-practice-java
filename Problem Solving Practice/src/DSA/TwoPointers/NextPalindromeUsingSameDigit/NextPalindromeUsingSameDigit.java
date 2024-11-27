package DSA.TwoPointers.NextPalindromeUsingSameDigit;

import java.util.Arrays;

public class NextPalindromeUsingSameDigit {
    public static void main(String[] args) {
        String numStr = "23143034132";
        System.out.print(new Solution().nextPalindrome(numStr));
    }
}

class Solution {
    public String nextPalindrome(String num) {
        int n = num.length();
        if (n < 3) {
            return "";
        }
        char[] chars = num.toCharArray();

        int mid = n / 2 - 1;
        int l = mid;
        while (l - 1 >= 0 && chars[l - 1] >= chars[l]) {
            l--;
        }
        if (l == 0) {
            return "";
        }
        while (mid > l && chars[mid] <= chars[l - 1]) {
            mid--;
        }
        swap(chars, mid, l - 1);
        swap(chars, n - 1 - mid, n - l);
        mid = n / 2;
        Arrays.sort(chars, l, mid);
        for (int i = l; i < mid; i++) {
            chars[n - 1 - i] = chars[i];
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
