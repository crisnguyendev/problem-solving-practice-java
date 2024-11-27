package DSA.TwoPointers.StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public static void main(String[] args) {
        String num = "619";
        System.out.println(new Solution().isStrobogrammatic(num));
    }
}


class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('8', '8');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsValue(num.charAt(right)) || num.charAt(left) != map.get(num.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}