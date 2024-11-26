package DSA.Sorting.MergeSort;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr, n);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void merge(int[] leftArray, int leftLength, int[] rightArray, int rightLength, int[] result, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                result[k] = leftArray[i];
                i++;
            } else {
                result[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            result[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            result[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int[] array, int n) {
        if (n <= 1)
            return;
        int leftLength = n / 2;
        int rightLength = n - leftLength;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        System.arraycopy(array, 0, leftArray, 0, leftLength);
        System.arraycopy(array, leftLength, rightArray, 0, rightLength);
        mergeSort(leftArray, leftLength);
        mergeSort(rightArray, rightLength);
        merge(leftArray, leftLength, rightArray, rightLength, array, n);
    }
}
