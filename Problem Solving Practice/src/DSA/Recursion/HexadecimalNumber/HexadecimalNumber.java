package DSA.Recursion.HexadecimalNumber;

import java.util.Scanner;

public class HexadecimalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(convertToHexadecimal(n));
    }

    private static String convertToHexadecimal(int num) {
        if (num < 10) {
            return String.valueOf(num);
        }
        if (num < 16) {
            int ch = num - 10 + 'A';
            return String.valueOf(Character.toChars(ch));
        }
        return convertToHexadecimal(num / 16) + convertToHexadecimal(num % 16);
    }
}
