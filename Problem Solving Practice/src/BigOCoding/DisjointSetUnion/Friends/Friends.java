package BigOCoding.DisjointSetUnion.Friends;

import java.util.Scanner;

public class Friends {
    private static int N;
    public static int[] parent;
    public static int[] rank;
    private static int[] friendCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            N = scanner.nextInt();
            int M = scanner.nextInt();
            parent = new int[N + 1];
            rank = new int[N + 1];
            friendCount = new int[N + 1];
            makeSet();
            for (int m = 0; m < M; m++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                unionSet(u, v);
            }
            System.out.println(findMaxSizeFriendGroup());
        }
    }

    private static void makeSet() {
        for (int n = 1; n <= N; n++) {
            parent[n] = n;
            rank[n] = 0;
            friendCount[n] = 1;
        }
    }

    private static int findMaxSizeFriendGroup(){
        int maxSize = 0;
        for (int n = 1; n <= N; n++) {
            maxSize = Math.max(maxSize, friendCount[n]);
        }
        return maxSize;
    }

    private static int findSet(int u) {
        if (parent[u] != u) {
            parent[u] = findSet(parent[u]);
        }
        return parent[u];
    }

    private static void unionSet(int u, int v) {
        int uRoot = findSet(u);
        int vRoot = findSet(v);
        if (uRoot == vRoot) {
            return;
        }
        if (rank[uRoot] < rank[vRoot]) {
            parent[uRoot] = vRoot;
            friendCount[vRoot]+= friendCount[uRoot];
        } else if (rank[uRoot] > rank[vRoot]) {
            parent[vRoot] = uRoot;
            friendCount[uRoot]+= friendCount[vRoot];
        } else {
            parent[vRoot] = uRoot;
            friendCount[uRoot]+= friendCount[vRoot];
            rank[uRoot]++;
        }
    }
}
