package MIU.Assignment.Lab04.SubsetSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Has subset: " + hasSubset(arr, k));

        List<Integer> subSetOne = getOneSubset(arr, k);
        System.out.printf("One subset sum = %d: \n", k);
        for (Integer value : subSetOne) {
            System.out.print(value + " ");
        }

        System.out.println();

        List<List<Integer>> allSubSets = getAllSubset(arr, k);
        System.out.printf("All subsets sum = %d: \n", k);
        for (List<Integer> subSet : allSubSets) {
            for (Integer i : subSet) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static boolean hasSubset(int[] arr, int k) {
        boolean[] subsetFound = new boolean[k + 1];
        subsetFound[0] = true;
        for (int value : arr) {
            subsetFound[value] = true;
            for (int j = value + 1; j <= k; j++) {
                int sub = j - value;
                if (subsetFound[sub] && sub != value)
                    subsetFound[j] = true;
            }
        }
        return subsetFound[k];
    }

    private static List<Integer> getOneSubset(int[] arr, int k) {

        List<Integer>[] subsets = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            subsets[i] = new ArrayList<>();
        }
        for (int value : arr) {
            subsets[value].add(value);

            for (int j = value + 1; j <= k; j++) {
                int sub = j - value;
                if (!subsets[sub].isEmpty() && sub != value) {
                    ArrayList<Integer> currentSubSet = new ArrayList<>(subsets[value]);
                    currentSubSet.add(sub);
                    subsets[j] = currentSubSet;
                }
            }
        }
        return subsets[k];
    }

    private static List<List<Integer>> getAllSubset(int[] arr, int k) {
        List<List<Integer>>[] subsets = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            subsets[i] = new ArrayList<>();
        }
        for (int value : arr) {
            subsets[value].add(List.of(value));
            for (int j = value + 1; j <= k; j++) {
                int sub = j - value;
                if (!subsets[sub].isEmpty() && sub != value) {
                    for (List<Integer> subset : subsets[value]) {
                        List<Integer> currentSubSet = new ArrayList<>(subset);
                        currentSubSet.add(sub);
                        subsets[j].add(currentSubSet);
                    }
                }
            }
        }
        return subsets[k];
    }

}
