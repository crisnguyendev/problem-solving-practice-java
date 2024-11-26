package DSA.Complexity.Approximating;

import java.util.Scanner;

public class Approximating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int countOfDistinctNumber = 0;
        int l = 0;
        int maxLength = 0;
        int[] frequency = new int[100001];
        for (int r = 0; r < n; r++) {
            if (frequency[arr[r]] == 0) {
                countOfDistinctNumber++;
            }
            frequency[arr[r]]++;
            while (l < n && countOfDistinctNumber > 2) {
                if (frequency[arr[l]] == 1) {
                    countOfDistinctNumber--;
                }
                frequency[arr[l]]--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        System.out.println(maxLength);
    }
}
