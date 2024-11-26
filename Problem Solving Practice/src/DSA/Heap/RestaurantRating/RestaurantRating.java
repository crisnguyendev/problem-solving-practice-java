package DSA.Heap.RestaurantRating;

import java.util.*;

public class RestaurantRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> topRating = new PriorityQueue<>();
        PriorityQueue<Integer> nonTopRating = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int totalReview = 0;
        for (int i = 0; i < n; i++) {
            int action = scanner.nextInt();
            if (action == 1) {
                totalReview++;
                int newRating = scanner.nextInt();
                if (!topRating.isEmpty()  && topRating.peek() < newRating) {
                    nonTopRating.add(topRating.poll());
                    topRating.add(newRating);
                } else {
                    nonTopRating.add(newRating);
                }
                if(totalReview % 3 == 0)
                    topRating.add(nonTopRating.poll());
            } else if (action == 2) {
                if(topRating.isEmpty())
                    System.out.println("No reviews yet");
                else
                    System.out.println(topRating.peek());
            }
        }
    }
}
