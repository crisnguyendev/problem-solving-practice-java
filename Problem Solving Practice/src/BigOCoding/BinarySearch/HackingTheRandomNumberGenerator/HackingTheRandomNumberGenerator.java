package BigOCoding.BinarySearch.HackingTheRandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HackingTheRandomNumberGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        Collections.sort(numbers);

        System.out.println(findPair(numbers, k));
    }

    private static int findPair(ArrayList<Integer> numbers, int k) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int x = numbers.get(i);
            int y = x + k;
            int left = i + 1;
            int right = numbers.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers.get(mid) > y) {
                    right = mid - 1;
                } else if (numbers.get(mid) < y) {
                    left = mid + 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

