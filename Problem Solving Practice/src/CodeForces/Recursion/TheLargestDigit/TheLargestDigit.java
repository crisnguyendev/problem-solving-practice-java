package CodeForces.Recursion.TheLargestDigit;

import java.util.Scanner;

public class TheLargestDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getLargestDigit(n));
    }

    private static int getLargestDigit(int n) {
        if (n < 0)
            return getLargestDigit(-n);
        if (n < 10)
            return n;
        return Math.max(getLargestDigit(n / 10), n % 10);
    }
}
