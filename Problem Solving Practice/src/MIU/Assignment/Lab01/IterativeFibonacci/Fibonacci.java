package MIU.Assignment.Lab01.IterativeFibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(fibonacci(i));
        }

    }

    private static int fibonacci(int n) {
        int prev = -1;
        int result = 1;
        for (int i = 0; i <= n; i++) {
            int sum = prev + result;
            prev = result;
            result = sum;
        }
        return result;
    }
}
