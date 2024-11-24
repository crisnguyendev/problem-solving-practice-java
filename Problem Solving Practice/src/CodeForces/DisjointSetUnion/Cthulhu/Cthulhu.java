package CodeForces.DisjointSetUnion.Cthulhu;

import java.util.Scanner;

public class Cthulhu {
    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalVertices = scanner.nextInt();
        int totalEdges = scanner.nextInt();
        parent = new int[totalVertices + 1];
        rank = new int[totalVertices + 1];
        for (int i = 0; i <= totalVertices; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < totalEdges; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            unionSet(x, y);
        }
        System.out.println(isCthulhu(totalVertices, totalEdges) ? "FHTAGN!" : "NO");

    }

    private static boolean isCthulhu(int totalVertices, int totalEdges) {
        if (totalVertices != totalEdges)
            return false;
        int root = findSet(1);
        for (int i = 2; i <= totalVertices; i++) {
            if (root != findSet(i))
                return false;
        }
        return true;
    }

    private static int findSet(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findSet(parent[x]);
    }

    private static void unionSet(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        if (rootX == rootY)
            return;
        if (rank[rootX] > rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
}
