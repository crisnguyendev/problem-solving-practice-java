package DSA.BellmanFord.Maelstrom;

import java.util.*;

public class Maelstrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProcessors = scanner.nextInt();
//        List<Edge> edges = new ArrayList<>();
        List<List<Node>> adjNodes = new ArrayList<>();
        for (int i = 0; i < numberOfProcessors; i++) {
            adjNodes.add(new ArrayList<>());
        }
        for (int i = 1; i < numberOfProcessors; i++) {
            for (int j = 0; j < i; j++) {
                String value = scanner.next();
                if (value.equals("x"))
                    continue;
                int expense = Integer.parseInt(value);
//                edges.add(new Edge(i, j, expense));
//                edges.add(new Edge(j, i, expense));
                adjNodes.get(i).add(new Node(j, expense));
                adjNodes.get(j).add(new Node(i, expense));
            }
        }
       // System.out.println(bellmanFord(0, numberOfProcessors, edges));
        System.out.println(dijkstra(0, numberOfProcessors, adjNodes));
    }

//    private static int bellmanFord(int start, int numberOfProcessors, List<Edge> edges) {
//        int[] expenses = new int[numberOfProcessors];
//        Arrays.fill(expenses, Integer.MAX_VALUE);
//        expenses[start] = 0;
//        int requiredExpense = 0;
//        for (int i = 0; i < numberOfProcessors - 1; i++) {
//            for (Edge edge : edges) {
//                if (expenses[edge.source] == Integer.MAX_VALUE)
//                    continue;
//                expenses[edge.target] = Math.min(expenses[edge.source] + edge.expense, expenses[edge.target]);
//            }
//        }
//        for (int i = 0; i < numberOfProcessors - 1; i++) {
//            requiredExpense = Math.max(requiredExpense, expenses[i]);
//        }
//        return requiredExpense;
//    }

    private static int dijkstra(int start, int numberOfProcessors, List<List<Node>> adjNodes) {
        int[] expenses = new int[numberOfProcessors];
        Arrays.fill(expenses, Integer.MAX_VALUE);
        expenses[start] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            for (Node adjNode : adjNodes.get(currentNode.id)) {
                if (expenses[currentNode.id] + adjNode.requiredExpense < expenses[adjNode.id]) {
                    expenses[adjNode.id] = expenses[currentNode.id] + adjNode.requiredExpense;
                    priorityQueue.add(new Node(adjNode.id, expenses[adjNode.id]));
                }
            }
        }
        int requiredExpense = 0;
        for (int i = 0; i < numberOfProcessors; i++) {
            requiredExpense = Math.max(requiredExpense, expenses[i]);
        }
        return requiredExpense;
    }
}

class Node implements Comparable<Node>{
    int id;
    int requiredExpense;

    public Node(int id, int requiredExpense) {
        this.id = id;
        this.requiredExpense = requiredExpense;
    }

    @Override
    public int compareTo(Node node) {
        return requiredExpense - node.requiredExpense;
    }
}

//class Edge {
//    int source;
//    int target;
//    int expense;
//
//    public Edge(int source, int target, int expense) {
//        this.source = source;
//        this.target = target;
//        this.expense = expense;
//    }
//}
