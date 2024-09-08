package BigOCoding.Recursion.BinaryNumber;

import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(convertBinaryNumber(n));
    }

    private static String convertBinaryNumber(int n) {
        if (n < 2) {
            return String.valueOf(n);
        } else {
            return convertBinaryNumber(n / 2) + convertBinaryNumber(n % 2);
        }
    }
}
