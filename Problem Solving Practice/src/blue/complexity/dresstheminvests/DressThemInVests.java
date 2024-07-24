package blue.complexity.dresstheminvests;

import java.util.Scanner;

class DressThemInVests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] soldiers = new int[n];
        int[] vests = new int[m];
        for (int i = 0; i < n; i++) {
            soldiers[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            vests[i] = scanner.nextInt();
        }
        int maxPair = Math.max(n, m);
        int[][] pairs = new int[maxPair][2];

        int waitingSoldier = 0;
        int availableVest = 0;
        int numberOfPairs = 0;
        while (waitingSoldier < n && availableVest < m) {
            if (vests[availableVest] < soldiers[waitingSoldier] - x) {
                availableVest++;
            } else if (vests[availableVest] <= soldiers[waitingSoldier] + y) {
                waitingSoldier++;
                availableVest++;
                pairs[numberOfPairs][0] = waitingSoldier;
                pairs[numberOfPairs][1] = availableVest;
                numberOfPairs++;
            } else {
                waitingSoldier++;
            }
        }
        System.out.println(numberOfPairs);
        for (int i = 0; i < numberOfPairs; i++) {
            System.out.print(pairs[i][0]);
            System.out.println(" " + pairs[i][1]);
        }
    }
}
