package LeetCode.Contest.Weekly420.CountSubstringsWithKFrequencyCharacters;


import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
                if (isValidString(charMap, k)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValidString(Map<Character, Integer> charMap, int k) {
        for (int count : charMap.values()) {
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}

public class CountSubstringsWithKFrequencyCharacters {
    public static void main(String[] args) {
        String input = "abacb";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings(input, k));
    }
}
