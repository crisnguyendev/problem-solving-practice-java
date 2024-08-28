package BigOCoding.StackAndQueue.ProcessingQueries;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessingQueries {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        Queue<Long> queue = new LinkedList<>();
        long completedTime = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            while (!queue.isEmpty() && queue.peek() <= t) {
                queue.remove();
            }

            if (queue.size() <= b) {
                completedTime = Math.max(completedTime, t) + d;
                System.out.printf("%d ", completedTime);
                queue.add(completedTime);
            } else {
                System.out.print("-1 ");
            }
        }
    }

}
