package blue.BinarySearch.Pizzamania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pizzamania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer> moneyOfFriends = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int money = scanner.nextInt();
                moneyOfFriends.add(money);
            }
            Collections.sort(moneyOfFriends);
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (findPair(moneyOfFriends, j + 1, n - 1, m - moneyOfFriends.get(j)))
                    result++;
            }
            System.out.println(result);
        }
    }

    private static boolean findPair(ArrayList<Integer> moneyOfFriends, int start, int end, int pairNumber) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (moneyOfFriends.get(mid) == pairNumber) {
                return true;
            } else if (moneyOfFriends.get(mid) > pairNumber) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
