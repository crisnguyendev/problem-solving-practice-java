package DSA.StackAndQueue.CompilersAndParsers;

import java.util.Scanner;
import java.util.Stack;

public class CompilersAndParsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String input = scanner.next();
            char[] chars = input.toCharArray();
            int maxLength = 0;
            int currentLength = 0;
            Stack<Character> stack = new Stack<>();
            for (char aChar : chars) {
                if (aChar == '<') {
                    stack.push(aChar);
                }
                if (aChar == '>') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        currentLength = currentLength + 2;
                        maxLength = Math.max(maxLength, currentLength);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(stack.isEmpty() ? maxLength : 0);
        }
    }
}
