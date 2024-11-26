package DSA.BinarySearch.Eko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Eko {
    private static ArrayList<Long> trees;
    private static long N;
    private static long M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        trees = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            trees.add(scanner.nextLong());
        }
        Collections.sort(trees);
        System.out.println(findHeightSetting());
    }

    private static long findHeightSetting() {
        long left = 0;
        long right = trees.get((int) N - 1);
        long heightSetting = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long wood = calculateWood(mid);
            if (wood < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                heightSetting = mid;
            }
        }
        return heightSetting;
    }

    private static long calculateWood(long heightSetting) {
        long total = 0;
        for (Long tree : trees) {
            total += Math.max(0, tree - heightSetting);
        }
        return total;
    }
}
