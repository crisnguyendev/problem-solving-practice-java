package BigOCoding.BinarySearch.MonkeyAndTheOiledBamboo;

import java.util.ArrayList;
import java.util.Scanner;

public class MonkeyAndTheOiledBamboo {
    private static ArrayList<Integer> rungs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            rungs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rungs.add(scanner.nextInt());
            }
            System.out.println("Case " + (i + 1) + ": " + findMinimumHStrength());
        }
    }

    private static int findMinimumHStrength() {
        int maxJump = 0;
        int count = 0;
        int lastHeight = 0;
        int lastJump = 0;
        for (int i = 0; i < rungs.size(); i++) {
            lastJump = rungs.get(i) - lastHeight;
            lastHeight = rungs.get(i);
            if (lastJump > maxJump) {
                maxJump = lastJump;
                count = 0;
            } else if (lastJump == maxJump) {
                count++;
            }
        }
        if (maxJump == lastJump && count > 0) {
            return maxJump + count - 1;
        } else {
            return maxJump + count;
        }
    }
}
