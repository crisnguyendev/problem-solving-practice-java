package BigOCoding.Sorting.Median;

import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        insertionSort(array, n);
        double median;
        if (array.length % 2 == 1) {
            median = array[array.length / 2];
        } else {
            median = (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        System.out.println(median);
    }

    private static void insertionSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int value = array[i];
            insert(array, i, value);
        }
    }

    private static void insert(int[] array, int n, int value) {
        int i = n;
        while (i > 0) {
            if (value > array[i - 1]) {
                break;
            }
            array[i] = array[i - 1];
            i--;
        }
        array[i] = value;
    }
}
