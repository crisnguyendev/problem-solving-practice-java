package BigOCoding.DisjointSetUnion.LostAndSurvived;

import java.util.Scanner;

public class LostAndSurvived {
    private static int N;
    private static int[] parent;
    private static int[] rank;
    private static int[] size;
    private static int maxSize;
    private static boolean[] visited;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        makeSet();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (findSet(A) != findSet(B)) {
                unionSet(A, B);
            }
            answerQuery();
        }
    }

    private static void makeSet() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        size = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        maxSize = 1;
    }

    private static int findSet(int x) {
        visited[x] = true;
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    private static void unionSet(int A, int B) {
        int rootA = findSet(A);
        int rootB = findSet(B);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] > rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        int newSize = size[rootA] + size[rootB];
        maxSize = Math.max(maxSize, newSize);
        size[rootA] = newSize;
        size[rootB] = newSize;
    }

    private static int getMinSize() {
        int minSize = N + 1;
        for (int i = 1; i <= N; i++) {
            if (visited[i] && size[i] < minSize) {
                minSize = size[i];
            }
        }
        return minSize <= N ? minSize : 1;
    }

    private static void answerQuery() {
        System.out.println(maxSize == N ? 0 : maxSize - getMinSize());
    }
}
