package DSA.TwoPointers.ValidWordAbbreviation;


public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "unovqgjxiqaokf";
        String abbr = "unov10";
        System.out.println(new Solution().validWordAbbreviation(word, abbr));
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length())
            return false;
        int abbrIndex = 0;
        int wordIndex = 0;
        while (abbrIndex < abbr.length() && wordIndex < word.length()) {
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                if (abbr.charAt(abbrIndex) - '0' == 0)
                    return false;
                int skipDigit = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    int newDigit = abbr.charAt(abbrIndex) - '0';
                    skipDigit = skipDigit * 10 + newDigit;
                    abbrIndex++;
                }
                wordIndex = wordIndex + skipDigit;
            } else {
                if (word.charAt(wordIndex) != abbr.charAt(abbrIndex))
                    return false;
                wordIndex++;
                abbrIndex++;
            }
        }
        return abbrIndex == abbr.length() && wordIndex == word.length();
    }
}