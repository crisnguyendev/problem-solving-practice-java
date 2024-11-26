package DSA.StackAndQueue.ThrowingCardsAwayI;

import java.util.*;

public class ThrowingCardsAwayI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
            List<Integer> throwAway = new ArrayList<>();
            while (queue.size() >= 2) {
                throwAway.add(queue.remove());
                int top = queue.poll();
                queue.add(top);
            }
            String discardedCard = "";
            for (int i = 0; i < throwAway.size(); i++) {
                if (i == 0) {
                    discardedCard += " " + throwAway.get(i);
                } else {
                    discardedCard += ", " + throwAway.get(i);
                }

            }
            System.out.println("Discarded cards:" + discardedCard);
            System.out.println("Remaining card: " + queue.poll());
        }
    }
}
