package DSA.Sorting.OddEvenSort;

import java.util.Scanner;

public class OddEvenSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array, n);
    }

    private static void sort(int[] array, int n) {
        int[] oddArray = new int[n];
        int[] evenArray = new int[n];
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!isEven(array[i])) {
                oddArray[j] = array[i];
                j++;
            } else {
                evenArray[k] = array[i];
                k++;
            }
        }
        insertionSortAsc(evenArray, k);
        insertionSortDesc(oddArray, j);
        j = 0;
        k = 0;
        for (int i = 0; i < n; i++) {
            if (isEven(array[i])) {
                System.out.print(evenArray[j]);
                j++;
            } else {
                System.out.print(oddArray[k]);
                k++;
            }
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static void insertionSortAsc(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int value = array[i];
            insertAsc(array, i, value);
        }
    }

    private static void insertAsc(int[] array, int n, int value) {
        int i = n;
        while (i > 0) {
            if (array[i - 1] < value) {
                break;
            }
            array[i] = array[i - 1];
            i--;
        }
        array[i] = value;
    }

    private static void insertionSortDesc(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int value = array[i];
            insertDes(array, i, value);
        }
    }

    private static void insertDes(int[] array, int n, int value) {
        int i = n;
        while (i > 0) {
            if (array[i - 1] > value) {
                break;
            }
            array[i] = array[i - 1];
            i--;
        }
        array[i] = value;
    }
}
