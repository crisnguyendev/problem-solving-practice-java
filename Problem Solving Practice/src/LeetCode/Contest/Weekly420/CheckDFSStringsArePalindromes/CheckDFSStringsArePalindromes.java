package LeetCode.Contest.Weekly420.CheckDFSStringsArePalindromes;

import java.util.Arrays;

class Solution {
    public boolean[] findAnswer(int[] parent, String s) {
        return new boolean[s.length()];
    }
}

public class CheckDFSStringsArePalindromes {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "aababa";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findAnswer(parent, s)));
    }


}
