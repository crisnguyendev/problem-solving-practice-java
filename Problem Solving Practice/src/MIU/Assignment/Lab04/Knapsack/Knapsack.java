package MIU.Assignment.Lab04.Knapsack;

import java.util.Scanner;

public class Knapsack {
    private static int[] weight;
    private static int[] value;
    private static int[][] valueTable;
    private static int n;
    private static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        weight = new int[n];
        value = new int[n];
        valueTable = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
            weight[i] = scanner.nextInt();
        }
        System.out.println(findIntegerKnapsack());
        printTable();
    }

    private static int findIntegerKnapsack() {
        for (int j = 0; j <= k; j++) {
            valueTable[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= weight[i] ) {
                    valueTable[i][j] = Math.max(valueTable[i - 1][j], value[i] + valueTable[i - 1][j - weight[i]]);
                } else {
                    valueTable[i][j] = valueTable[i - 1][j];
                }
            }
        }
        return valueTable[n - 1][k];
    }

    private static void printTable() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(valueTable[i][j] + " ");
            }
            System.out.println();
        }
    }

}
