package DSA.Abstraction.SumOfFraction;

import java.util.Scanner;

public class SumOfFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraction fraction1 = new Fraction(scanner.nextInt(), scanner.nextInt());
        Fraction fraction2 = new Fraction(scanner.nextInt(), scanner.nextInt());
        Fraction fraction3 = Fraction.sum(fraction1, fraction2);
        System.out.println(fraction3);
    }
}

class Fraction {
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
        return this.numerator + " " + this.denominator;
    }

    static Fraction sum(Fraction fraction1, Fraction fraction2) {
        int sumNumerator = fraction1.getNumerator() * fraction2.denominator + fraction2.getNumerator() * fraction1.getDenominator();
        int sumDenominator = fraction1.getDenominator() * fraction2.getDenominator();
        int gcd = gcd(sumNumerator, sumDenominator);
        return new Fraction(sumNumerator / gcd, sumDenominator / gcd);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}
