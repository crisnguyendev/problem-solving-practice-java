package blue.stackandqueue.massofmolecule;

import java.util.Scanner;
import java.util.Stack;

public class MassOfMolecule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chars = input.toCharArray();
        Stack<Integer> group = new Stack<>();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                group.push(getMass(c));
            }
            if (Character.isDigit(c)) {
                int mass = group.pop() * (c - '0');
                group.push(mass);
            }
            if (c == '(') {
                group.push(0);
            }
            if (c == ')') {
                int sumAtom = 0;
                while (!group.isEmpty() && group.peek() != 0) {
                    sumAtom += group.pop();
                }
                group.pop();
                group.push(sumAtom);
            }
        }

        int totalMass = 0;
        while (!group.isEmpty()) {
            totalMass += group.pop();
        }
        System.out.println(totalMass);
    }

    private static int getMass(char c) {
        switch (c) {
            case 'H':
                return 1;
            case 'C':
                return 12;
            case 'O':
                return 16;
            default:
                return 0;
        }
    }
}
