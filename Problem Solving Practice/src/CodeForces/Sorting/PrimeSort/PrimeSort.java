package CodeForces.Sorting.PrimeSort;

import java.util.Scanner;

public class PrimeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        sortPrimes(array, n);
        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                System.out.println(array[i]);
            else
                System.out.print(array[i] + " ");
        }
    }

    private static void sortPrimes(int[] array, int n) {
        int totalPrime = 0;
        int[] nonPrimes = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(array[i])) {
                totalPrime++;
            } else {
                nonPrimes[j] = array[i];
                j++;
            }
        }
        mergeSort(nonPrimes, n - totalPrime);
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(array[i]))
                continue;
            array[i] = nonPrimes[k];
            k++;
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void merge(int[] leftArray, int leftLength, int[] rightArray, int rightLength, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
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
        merge(leftArray, leftLength, rightArray, rightLength, array);
    }
}
