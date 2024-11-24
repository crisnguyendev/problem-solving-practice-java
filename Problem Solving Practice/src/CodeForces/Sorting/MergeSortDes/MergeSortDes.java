package CodeForces.Sorting.MergeSortDes;

import java.util.Scanner;

public class MergeSortDes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        mergeSortDes(array, n);
        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " ");
        }
    }

    private static void mergeSortDes(int[] array, int n) {
        if (n <= 1)
            return;
        int leftLength = n / 2;
        int rightLength = n - leftLength;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        System.arraycopy(array, 0, leftArray, 0, leftLength);
        System.arraycopy(array, leftLength, rightArray, 0, rightLength);
        mergeSortDes(leftArray, leftLength);
        mergeSortDes(rightArray, rightLength);
        merge(leftArray, leftLength, rightArray, rightLength, array, n);
    }

    private static void merge(int[] leftArray, int leftLength, int[] rightArray, int rightLength, int[] result, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                result[k] = rightArray[j];
                j++;
            } else {
                result[k] = leftArray[i];
                i++;
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

}
