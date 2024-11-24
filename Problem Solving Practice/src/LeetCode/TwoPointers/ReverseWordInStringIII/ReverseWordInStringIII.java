package LeetCode.TwoPointers.ReverseWordInStringIII;

public class ReverseWordInStringIII {
    public static void main(String[] args) {
        String s = "ABC  DE  ";
        System.out.println(new Solution().reverseWords(s));
    }
}

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ' || i == n - 1) {
                int end = (chars[i] == ' ') ? i - 1 : i;
                reverse(chars, start, end);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}