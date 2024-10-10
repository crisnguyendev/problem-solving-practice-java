package BigOCoding.Sorting.QuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private static void quicksort(int[] arr, int start, int stop) {
        int i, j;
        if (stop <= start)
            return;
        int pivotPos = medianOfThree(arr, start, stop);
        swap(arr, pivotPos, stop);
        int pivot = arr[stop];
        i = start;
        j = stop - 1;
        while (true) {
            while (i <= j && arr[i] < pivot) i++;
            while (i <= j && arr[j] > pivot) j--;
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, stop, i);
        quicksort(arr, start, i - 1);
        quicksort(arr, i + 1, stop);

    }

    private static int medianOfThree(int[] arr, int start, int stop) {
        int mid = start + (stop - start) / 2;
        if (arr[start] > arr[mid]) {
            swap(arr, start, mid);
        }
        if (arr[start] > arr[stop]) {
            swap(arr, start, stop);
        }
        if (arr[mid] > arr[stop]) {
            swap(arr, mid, stop);
        }
        return mid;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
