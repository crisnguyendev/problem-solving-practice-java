package MIU.Assignment.Lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSelect {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println(quickSelect(list, (n - 1) / 2));
    }

    public static int quickSelect(List<Integer> list, int index) {
        int pivotIndex = (list.size() - 1) / 2;
        int pivot = list.get(pivotIndex);
        List<List<Integer>> partionLists = partition(list, pivot);
        int k = index + 1;
        if (partionLists.get(0).size() < k && partionLists.get(0).size() + partionLists.get(1).size() >= k) {
            return partionLists.get(1).get(0);
        } else if (partionLists.get(0).size() >= k) {
            return quickSelect(partionLists.get(0), k);
        } else {
            return quickSelect(partionLists.get(2), k - partionLists.get(0).size() - partionLists.get(1).size());
        }
    }

    private static List<List<Integer>> partition(List<Integer> list, int pivot) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(new ArrayList<>());
        }
        for (int value : list) {
            if (value == pivot)
                result.get(1).add(value);
            else if (value > pivot)
                result.get(2).add(value);
            else
                result.get(0).add(value);
        }
        return result;
    }
}
