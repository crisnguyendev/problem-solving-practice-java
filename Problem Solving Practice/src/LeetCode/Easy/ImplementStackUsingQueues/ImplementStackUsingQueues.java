package LeetCode.Easy.ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}

class MyStack {
    private final Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for (int i = 1; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    public int top() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
