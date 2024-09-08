package LeetCode.Easy.LengthOfLastWord;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println(new Solution().lengthOfLastWord(input));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(" ");
        if (index != -1) {
            return s.length() - index - 1;
        } else {
            return s.length();
        }
    }
}
