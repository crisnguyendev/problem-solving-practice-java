package BigOCoding.Heap.RoyAndTrendingTopic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RoyAndTrendingTopic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Topic> maxHeap = new PriorityQueue<>(new Comparator<Topic>() {
            @Override
            public int compare(Topic topic1, Topic topic2) {
                if (topic1.changedScore == topic2.changedScore)
                    return topic2.id - topic1.id;
                return topic2.changedScore - topic1.changedScore;
            }
        });
        for (int i = 1; i <= n; i++) {
            int id = scanner.nextInt();
            int originalScore = scanner.nextInt();
            int post = scanner.nextInt();
            int like = scanner.nextInt();
            int comment = scanner.nextInt();
            int share = scanner.nextInt();
            int newScore = post * 50 + like * 5 + comment * 10 + share * 20;
            Topic topic = new Topic(id, newScore, newScore - originalScore);
            maxHeap.add(topic);
        }
        int i = 0;
        while (!maxHeap.isEmpty() && i < 5) {
            System.out.println(maxHeap.poll());
            i++;
        }
    }

    static class Topic {
        int id;
        int newScore;
        int changedScore;

        public Topic(int id, int newScore, int changedScore) {
            this.id = id;
            this.newScore = newScore;
            this.changedScore = changedScore;
        }

        @Override
        public String toString() {
            return id + " " + newScore;
        }
    }
}

