package DSA.ModifiedBinarySearch.FindKClosestElement;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 15, 25, 35, 45, 50, 59};
        int k = 1;
        int x = 30;
        System.out.print(new Solution().findClosestElements(arr, k, x));
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        if (k == n) {
            for (int num : arr) {
                result.add(num);
            }
            return result;
        }
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (x > arr[n - 1]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[n - k + i]);
            }
            return result;
        }

        int foundIndex = findTarget(arr, x);
        int left = foundIndex;
        int right = foundIndex;
        for (int i = 0; i < k - 1; i++) {
            int leftDistance = left - 1 < 0 ? Integer.MAX_VALUE : Math.abs(arr[left - 1] - x);
            int rightDistance = right + 1 > n - 1 ? Integer.MAX_VALUE : Math.abs(arr[right + 1] - x);
            if (leftDistance <= rightDistance) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    private int findTarget(int[] arr, int x) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left + 1 == right)
                return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
            int mid = (right + left) / 2;
            int midValue = arr[mid];
            if (midValue == x)
                return mid;
            if (x > midValue)
                left = mid;
            else
                right = mid;
        }
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
    }
}

class OptimalSolution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        int mid;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(arr[left + i]);
        }
        return result;
    }
}