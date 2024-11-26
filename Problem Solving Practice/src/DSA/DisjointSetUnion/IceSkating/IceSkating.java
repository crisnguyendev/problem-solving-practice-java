package DSA.DisjointSetUnion.IceSkating;

import java.util.Scanner;

public class IceSkating {
    private static int N;
    private static int[] parent;
    private static int[] rank;
    private static int[] x;
    private static int[] y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        makeSet();
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(getMinimalCreatedSnowDrift());

    }

    private static int getMinimalCreatedSnowDrift() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (x[i] == x[j] || y[i] == y[j]) {
                    unionSet(i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (parent[i] == i)
                count++;
        }
        return count - 1;
    }

    private static void makeSet() {
        parent = new int[N];
        rank = new int[N];
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    private static void unionSet(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        if (rootX == rootY)
            return;
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
