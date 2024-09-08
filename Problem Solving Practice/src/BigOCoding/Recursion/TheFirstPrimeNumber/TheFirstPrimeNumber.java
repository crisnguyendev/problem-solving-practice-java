package BigOCoding.Recursion.TheFirstPrimeNumber;

import java.util.Scanner;

public class TheFirstPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(firstPrime(array, 0));
    }

    private static int firstPrime(int[] array, int n) {
        if (n == array.length)
            return -1;
        if (isPrime(array[n], 2))
            return n;
        return firstPrime(array, n + 1);
    }

    private static boolean isPrime(int n, int divisor) {
        if (n < 2) return false;
        if (divisor > Math.sqrt(n)) return true;
        if (n % divisor == 0) return false;
        return isPrime(n, divisor + 1);
    }
}
