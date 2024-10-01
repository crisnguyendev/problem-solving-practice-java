package MIU.Assignment.Lab01.IterativeGCD;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(33, 22));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
