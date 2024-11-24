package CodeForces.Recursion.SumOfEven;

import java.util.Scanner;

public class SumOfEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(sumOfEven(array, 0));
    }

    private static int sumOfEven(int[] array, int n) {
        if (n == array.length)
            return 0;
        return array[n] % 2 == 0 ? array[n] + sumOfEven(array, n + 1) : sumOfEven(array, n + 1);
    }
}
