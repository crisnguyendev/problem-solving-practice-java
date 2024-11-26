package DSA.Recursion.FibonacciNumber;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
