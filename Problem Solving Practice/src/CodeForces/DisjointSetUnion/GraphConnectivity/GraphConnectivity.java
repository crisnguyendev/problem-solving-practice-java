package CodeForces.DisjointSetUnion.GraphConnectivity;

import java.util.Scanner;

public class GraphConnectivity {
    private static int totalNode;
    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        String next;
        while (T-- > 0) {
            next = scanner.nextLine();
            totalNode = next.charAt(0) - 'A' + 1;
            makeSet();
            while (scanner.hasNextLine()) {
                next = scanner.nextLine();
                if (next.isEmpty())
                    break;
                int u = next.charAt(0) - 'A';
                int v = next.charAt(1) - 'A';
                unionSet(u, v);
            }
            System.out.println(getMaximalConnectedSubgraph());
            if (T > 0)
                System.out.println();
        }
    }

    private static void makeSet() {
        parent = new int[totalNode];
        rank = new int[totalNode];
        for (int i = 0; i < totalNode; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static int findSet(int v) {
        if (parent[v] != v) {
            return parent[v] = findSet(parent[v]);
        }
        return parent[v];
    }

    private static void unionSet(int u, int v) {
        int uRoot = findSet(u);
        int vRoot = findSet(v);
        if (uRoot == vRoot) {
            return;
        }
        if (rank[uRoot] < rank[vRoot]) {
            parent[uRoot] = vRoot;
        } else if (rank[uRoot] > rank[vRoot]) {
            parent[vRoot] = uRoot;
        } else {
            parent[vRoot] = uRoot;
            rank[uRoot]++;
        }
    }

    private static int getMaximalConnectedSubgraph() {
        int count = 0;
        for (int i = 0; i < totalNode; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private static int findConnected(int v) {
        if (parent[v] != v) {
            return parent[v] = findSet(parent[v]);
        }
        return parent[v];
    }
}
