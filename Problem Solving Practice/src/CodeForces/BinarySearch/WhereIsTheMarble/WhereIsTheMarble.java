package CodeForces.BinarySearch.WhereIsTheMarble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhereIsTheMarble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        while (true) {
            int N = scanner.nextInt();
            int Q = scanner.nextInt();
            if (N == 0 && Q == 0)
                break;
            ArrayList<Integer> marbles = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                marbles.add(scanner.nextInt());
            }
            Collections.sort(marbles);
            System.out.println("CASE# " + caseNumber + ":");
            caseNumber++;
            for (int i = 0; i < Q; i++) {
                int x = scanner.nextInt();
                int index = binaryFirstSearch(marbles, x);
                if (index < 0) {
                    System.out.println(x + " not found");
                } else {
                    System.out.println(x + " found at " + (index + 1));
                }

            }
        }
    }

    private static int binaryFirstSearch(ArrayList<Integer> marbles, int x) {
        int left = 0;
        int right = marbles.size() - 1;
        int position = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == left || x != marbles.get(mid - 1)) && x == marbles.get(mid)) {
                position = mid;
                break;
            } else if (x > marbles.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return position;
    }
}
