package MIU.Assignment.Lab07.Question03;

import java.util.Arrays;
import java.util.Scanner;

public class FBSArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        quickSortAsc(array, 1, (n - 1) % 2 == 0 ? n - 2 : n - 1);
        quickSortDes(array, 0, (n - 1) % 2 == 0 ? n - 1 : n - 2);
        System.out.println(Arrays.toString(array));
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static void quickSortAsc(int[] arr, int start, int stop) {
        int i, j;
        if (stop <= start)
            return;
        int pivotPos = medianOfThree(arr, start, stop);
        swap(arr, pivotPos, stop);
        int pivot = arr[stop];
        i = start;
        j = stop - 2;
        while (true) {
            while (i <= j && arr[i] < pivot)
                i = i + 2;
            while (i <= j && arr[j] > pivot)
                j = j - 2;
            if (i > j)
                break;
            swap(arr, i, j);
            i = i + 2;
            j = j - 2;
        }
        swap(arr, stop, i);
        quickSortAsc(arr, start, i - 2);
        quickSortAsc(arr, i + 2, stop);
    }

    private static void quickSortDes(int[] arr, int start, int stop) {
        int i, j;
        if (stop <= start)
            return;
        int pivotPos = medianOfThree(arr, start, stop);
        swap(arr, pivotPos, stop);
        int pivot = arr[stop];
        i = start;
        j = stop - 2;
        while (true) {
            while (i <= j && arr[i] > pivot)
                i = i + 2;
            while (i <= j && arr[j] < pivot)
                j = j - 2;
            if (i > j)
                break;
            swap(arr, i, j);
            i = i + 2;
            j = j - 2;
        }
        swap(arr, stop, i);
        quickSortDes(arr, start, i - 2);
        quickSortDes(arr, i + 2, stop);
    }

    private static int medianOfThree(int[] arr, int start, int stop) {
        int mid = start + (stop - start) / 2;
        if (mid + start % 2 > 0)
            mid++;
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
