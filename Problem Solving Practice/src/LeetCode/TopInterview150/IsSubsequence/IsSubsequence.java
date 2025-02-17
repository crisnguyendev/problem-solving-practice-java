package LeetCode.TopInterview150.IsSubsequence;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println(new Solution().isSubsequence(s, t));
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        if (s.length() > t.length())
            return false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length())
                    return true;
            }
        }
        return false;
    }
}