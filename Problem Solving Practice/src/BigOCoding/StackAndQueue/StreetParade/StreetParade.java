package BigOCoding.StackAndQueue.StreetParade;

import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int[] mobiles = new int[n];
            for (int i = 0; i < n; i++) {
                mobiles[i] = scanner.nextInt();
            }
            tryReorderMobile(mobiles, n);
        }

    }

    private static void tryReorderMobile(int[] mobiles, int n) {
        Stack<Integer> sideStreetStack = new Stack<>();

        int nextMobile = 1;
        for (int i = 0; i < n; i++) {
            while (!sideStreetStack.isEmpty() && sideStreetStack.peek() == nextMobile) {
                sideStreetStack.pop();
                nextMobile++;
            }
            if (mobiles[i] == nextMobile) {
                nextMobile++;
            } else {
                sideStreetStack.push(mobiles[i]);
            }
        }
        while (!sideStreetStack.isEmpty() && sideStreetStack.peek() == nextMobile && nextMobile <= n) {
            sideStreetStack.pop();
            nextMobile++;
        }
        System.out.println(sideStreetStack.isEmpty() ? "yes" : "no");
    }
}
