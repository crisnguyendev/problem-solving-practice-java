package MIU.Assignment.Lab02.FindThirdLargestInArray;

import java.util.Scanner;

public class FindThirdLargestInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(findThirdLargest(array));
    }

    private static int findThirdLargest(int[] array) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (int number : array) {
            if (number > firstMax) {
                firstMax = number;
            } else if (number > secondMax) {
                secondMax = number;
            } else if (number > thirdMax) {
                thirdMax = number;
            }
        }
        return thirdMax;
    }
}
