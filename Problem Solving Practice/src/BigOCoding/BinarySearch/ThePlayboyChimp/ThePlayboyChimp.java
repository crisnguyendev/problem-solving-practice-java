package BigOCoding.BinarySearch.ThePlayboyChimp;

import java.util.ArrayList;
import java.util.Scanner;

public class ThePlayboyChimp {
    private static int N;
    private static int Q;
    private static ArrayList<Integer> chimpLadies;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        chimpLadies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            chimpLadies.add(scanner.nextInt());
        }
        Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            findLady(scanner.nextInt());
        }
    }

    private static void findLady(int height) {

        int tallestIndex = -1;
        int shortestIndex = N;
        int left = 0;
        int right = chimpLadies.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (chimpLadies.get(mid) > height) {
                right = mid - 1;
                shortestIndex = Math.min(shortestIndex, mid);
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = chimpLadies.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (chimpLadies.get(mid) < height) {
                left = mid + 1;
                tallestIndex = Math.max(tallestIndex, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(
                (isValid(tallestIndex) ? chimpLadies.get(tallestIndex) : "X")
                        + " "
                        + (isValid(shortestIndex) ? chimpLadies.get(shortestIndex) : "X"));
    }

    private static boolean isValid(int index) {
        return index >= 0 && index < N;
    }
}
