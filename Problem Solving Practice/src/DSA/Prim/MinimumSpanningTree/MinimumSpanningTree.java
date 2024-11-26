package DSA.Prim.MinimumSpanningTree;

import java.util.*;

public class MinimumSpanningTree {
    private static boolean[] visited;
    private static int[] distances;
    private static int[] path;
    private static int[] rank;
    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        List<List<Node>> adjEdges = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i <= numberOfNodes; i++) {
            adjEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < numberOfEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            adjEdges.get(u).add(new Node(v, weight));
            adjEdges.get(v).add(new Node(u, weight));
            edges.add(new Edge(u, v, weight));
        }
        kruskal(numberOfNodes, edges);
    }

    private static void printPrimMST() {
        long mstDistance = 0;
        for (int i = 1; i < distances.length; i++) {
            if (path[i] == -1)
                continue;
            mstDistance += distances[i];
        }
        System.out.println(mstDistance);
    }

    private static void prim(int numberOfNodes, List<List<Node>> adjEdges) {
        visited = new boolean[numberOfNodes + 1];
        distances = new int[numberOfNodes + 1];
        path = new int[numberOfNodes + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(1, 0));
        path[1] = 1;
        distances[1] = 0;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            visited[node.id] = true;
            if (distances[node.id] < node.weight)
                continue;
            for (Node adjNode : adjEdges.get(node.id)) {
                if (!visited[adjNode.id] && adjNode.weight < distances[adjNode.id]) {
                    distances[adjNode.id] = adjNode.weight;
                    path[adjNode.id] = node.id;
                    priorityQueue.add(new Node(adjNode.id, adjNode.weight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int weight;

        Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    private static void kruskal(int numberOfNodes, List<Edge> edges) {
        Collections.sort(edges);
        List<Edge> mstEdges = new ArrayList<>();
        rank = new int[numberOfNodes + 1];
        parent = new int[numberOfNodes + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i <= numberOfNodes; i++) {
            parent[i] = i;
        }
        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                mstEdges.add(edge);
            }
            if (mstEdges.size() == numberOfNodes - 1)
                break;
        }
        long mstWeight = 0;
        for (Edge edge : mstEdges) {
            mstWeight += edge.weight;
        }
        System.out.println(mstWeight);
    }

    private static boolean union(int u, int v) {
        int rootU = findSet(u);
        int rootV = findSet(v);
        if (rootU == rootV) {
            return false;
        }
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            rank[rootU] += rank[rootV];
        } else {
            parent[rootU] = rootV;
            rank[rootV] += rank[rootU];
        }
        return true;
    }

    private static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }
}

