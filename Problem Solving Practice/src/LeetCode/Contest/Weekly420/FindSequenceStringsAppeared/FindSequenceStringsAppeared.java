package LeetCode.Contest.Weekly420.FindSequenceStringsAppeared;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        StringBuilder last = new StringBuilder();
        char[] chars = target.toCharArray();
        char c = 'a';
        for (int i = 0; i < chars.length; i++) {
            res.add(last.toString() + 'a');
            for (c = 'b'; c <= chars[i]; c++) {
                res.add(last.toString() + c);
            }
            last.append((char) (c - 1));
        }
        return res;
    }
}


public class FindSequenceStringsAppeared {
    public static void main(String[] args) {
        String target = "he";
        Solution solution = new Solution();
        System.out.println(solution.stringSequence(target));
    }
}
