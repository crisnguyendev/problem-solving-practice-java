package BigOCoding.Recursion.BiggestOddDivisor;

import java.util.Scanner;

public class BiggestOddDivisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(biggestOddDivisor(n));
    }

    private static int biggestOddDivisor(int n) {
        if (n % 2 != 0) {
            return n;
        }
        return biggestOddDivisor(n / 2);
    }
}
