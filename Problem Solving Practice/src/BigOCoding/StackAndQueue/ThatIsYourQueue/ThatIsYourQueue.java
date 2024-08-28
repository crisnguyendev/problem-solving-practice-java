package BigOCoding.StackAndQueue.ThatIsYourQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThatIsYourQueue {
    public static void main(String[] args) {
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int P = scanner.nextInt();
            int C = scanner.nextInt();
            if (P == 0 && C == 0) {
                break;
            }
            Queue<Integer> queue = new LinkedList<>();
            int length = Math.min(P, C);
            for (int i = 1; i <= length; i++) {
                queue.add(i);
            }
            System.out.println("Case " + caseNumber + ":");
            caseNumber++;
            for (int i = 1; i <= C; i++) {
                String command = scanner.next();
                if (command.equals("N")) {
                    int admittedNumber = queue.remove();
                    System.out.println(admittedNumber);
                    queue.add(admittedNumber);
                } else {
                    int x = scanner.nextInt();
                    queue.remove(x);
                    queue.add(x);
                    while (queue.peek() != x){
                        int temp = queue.remove();
                        queue.add(temp);
                    }
                }
            }
        }
    }
}
