package LeetCode.Blind75.GreatestCommonDivisorOfStrings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args){
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.print(new Solution().gcdOfStrings(str1, str2));
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int max = Math.max(str1.length(), str2.length());
        int min = Math.min(str1.length(), str2.length());
        int gcdLength = gcd(max, min);
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}