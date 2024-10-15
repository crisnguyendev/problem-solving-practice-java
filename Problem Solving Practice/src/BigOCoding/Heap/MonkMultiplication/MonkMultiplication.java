package BigOCoding.Heap.MonkMultiplication;

import java.util.Scanner;

public class MonkMultiplication {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}
