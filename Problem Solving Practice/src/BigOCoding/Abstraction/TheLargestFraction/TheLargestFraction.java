package BigOCoding.Abstraction.TheLargestFraction;

import java.util.Arrays;
import java.util.Scanner;

public class TheLargestFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Fraction[] fractions = new Fraction[N];
        for (int i = 0; i < N; i++) {
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            int gcd = gcd(numerator, denominator);
            fractions[i] = new Fraction(numerator / gcd, denominator / gcd);
        }
        Arrays.sort(fractions, (fraction1, fraction2) -> fraction1.getNumerator() * fraction2.getDenominator() - fraction1.getDenominator() * fraction2.getNumerator());
        System.out.println(fractions[N - 1]);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}


class Fraction implements Comparable<Fraction> {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + " " + denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        return 0;
    }
}
