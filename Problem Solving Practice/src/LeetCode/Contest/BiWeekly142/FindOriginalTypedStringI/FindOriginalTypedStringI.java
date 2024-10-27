package LeetCode.Contest.BiWeekly142.FindOriginalTypedStringI;


class Solution {
    public int possibleStringCount(String word) {
        char lastChar = word.charAt(0);
        int result = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == lastChar) {
                result++;
            } else {
                lastChar = word.charAt(i);
            }
        }
        return result;
    }
}

public class FindOriginalTypedStringI {
    public static void main(String[] args) {
        String word = "abccc";
        System.out.println(new Solution().possibleStringCount(word));
    }
}
