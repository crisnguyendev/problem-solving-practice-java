package DSA.Recursion.SymmetricalString;

import java.util.Scanner;

public class SymmetricalString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(isSymmetrical(s) ? "YES" : "NO");
    }

    private static boolean isSymmetrical(String s) {
        if (s.length() == 1)
            return true;
        if(s.length() == 2 && s.charAt(0) == s.charAt(1))
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isSymmetrical(s.substring(1, s.length() - 1));
        return false;
    }
}
