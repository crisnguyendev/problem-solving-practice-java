package DSA.FastAndSlowPointers.HappyNumber;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.print(new Solution().isHappy(19));
    }
}

class Solution {
    public boolean isHappy(int n) {
        int s = n;
        int f = sumOfSquaredDigits(s);
        while (s != f && f != 1) {
            s = sumOfSquaredDigits(s);
            f = sumOfSquaredDigits(sumOfSquaredDigits(f));
        }
        return f == 1;
    }

    private int sumOfSquaredDigits(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n = n / 10;
        }
        return result;
    }
}