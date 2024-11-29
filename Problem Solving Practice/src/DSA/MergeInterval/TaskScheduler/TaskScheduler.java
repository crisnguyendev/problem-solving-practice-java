package DSA.MergeInterval.TaskScheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskScheduler {
    // Driver code
    public static void main(String[] args) {
        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        Solution solution = new Solution();
        for (int i = 0; i < allTasks.length; i++) {
            System.out.print((i + 1) + ".\tTasks: ");
            char[] tasks = allTasks[i];
            for (int j = 0; j < tasks.length; j++) {
                System.out.print(tasks[j]);
                if (j != tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n\tn: " + allNs[i]);

            int minTime = solution.leastInterval(allTasks[i], allNs[i]);
            System.out.println("\tMinimum time required to execute the tasks: " + minTime);
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}

class CharInterval {
    int charIndex;
    int interval;

    public CharInterval(int charIndex, int interval) {
        this.charIndex = charIndex;
        this.interval = interval;
    }
}

class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)

    public int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        List<CharInterval> charIntervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                charIntervals.add(new CharInterval(i, freq[i]));
        }
        charIntervals.sort((a, b) -> b.interval - a.interval);
        CharInterval maxCharInterval = charIntervals.get(0);
        int size = charIntervals.size();
        int idle = (maxCharInterval.interval - 1) * n;
        for (int i = 1; i < size && idle > 0; i++) {
            CharInterval charInterval = charIntervals.get(i);
            idle = idle - Math.min(maxCharInterval.interval - 1, charInterval.interval);
        }
        return length + Math.max(0, idle);
    }
}