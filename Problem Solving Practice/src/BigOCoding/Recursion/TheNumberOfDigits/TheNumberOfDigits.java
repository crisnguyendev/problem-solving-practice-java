package BigOCoding.Recursion.TheNumberOfDigits;

import java.util.Scanner;

public class TheNumberOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(numberOfDigits(n));
    }

    private static int numberOfDigits(int n) {
        if (n < 0)
            return numberOfDigits(-n);
        if (n < 10)
            return 1;
        return numberOfDigits(n / 10) + 1;
    }
}
