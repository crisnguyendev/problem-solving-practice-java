package BigOCoding.Sorting.InsertionSort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        insertionSort(arr, n);
        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            insert(arr, i, value);
        }
    }

    private static void insert(int[] array, int n, int value) {
        int j = n;
        while (j > 0) {
            if (array[j - 1] <= value){
                break;
            }
            array[j] = array[j - 1];
            j--;
        }
        array[j] = value;
    }
}
