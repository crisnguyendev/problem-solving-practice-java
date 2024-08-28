package BigOCoding.Complexity.georgeandround;

import java.util.Scanner;

public class GeorgeAndRound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        int result = 0;
        int k = 0;
        boolean matched = false;
        for (int i = 0; i < n; i++) {
            matched = false;
            while (k < m) {
                if (b[k] >= a[i]) {
                    matched = true;
                    k++;
                    break;
                }
                k++;
            }
            if (!matched) {
                result++;
            }

        }
        System.out.println(result);
    }
}
