package BigOCoding.Heap.ICanGuessDataStructure;

import java.util.*;

public class ICanGuessDataStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            stack.clear();
            queue.clear();
            priorityQueue.clear();
            int isStack = 1;
            int isQueue = 1;
            int isPriorityQueue = 1;
            for (int i = 0; i < n; i++) {
                int operation = scanner.nextInt();
                int value = scanner.nextInt();
                if (operation == 1) {
                    stack.push(value);
                    queue.add(value);
                    priorityQueue.add(value);
                }
                if (operation == 2) {
                    if (stack.empty()) {
                        isStack = isQueue = isPriorityQueue = 0;
                        continue;
                    }

                    if (stack.pop() != value) {
                        isStack = 0;
                    }
                    if (queue.poll() != value) {
                        isQueue = 0;
                    }
                    if (priorityQueue.poll() != value) {
                        isPriorityQueue = 0;
                    }
                }
            }
            if (isPriorityQueue + isStack + isQueue == 0)
                System.out.println("impossible");
            else if (isPriorityQueue + isStack + isQueue > 1)
                System.out.println("not sure");
            else if (isStack == 1)
                System.out.println("stack");
            else if (isQueue == 1)
                System.out.println("queue");
            else
                System.out.println("priority queue");
        }
    }
}

