package BigOCoding.Recursion.TheFirstDigit;

import java.util.Scanner;

public class TheFirstDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(firstDigit(n));
    }

    private static int firstDigit(int n) {
        if (n < 0)
            return firstDigit(-n);
        if (n < 10)
            return n;
        return firstDigit(n / 10);
    }
}
