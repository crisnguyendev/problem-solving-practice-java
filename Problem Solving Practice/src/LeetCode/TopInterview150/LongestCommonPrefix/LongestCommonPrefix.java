package LeetCode.TopInterview150.LongestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
