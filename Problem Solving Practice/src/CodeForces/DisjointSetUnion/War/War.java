package CodeForces.DisjointSetUnion.War;

import java.util.Scanner;

public class War {
    private static int N;
    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        makeSet();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int c = Integer.parseInt(split[0]);
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[2]);
            if (c == 0 && x == 0 && y == 0) {
                break;
            }
            if (c == 1) {
                if (areEnemies(x, y)) {
                    System.out.println(-1);
                } else {
                    unionSet(x, y);
                    unionSet(x + N, y + N);
                }

            } else if (c == 2) {
                if (areFriends(x, y)) {
                    System.out.println(-1);
                } else {
                    unionSet(x, y + N);
                    unionSet(x + N, y);
                }
                continue;
            } else if (c == 3) {
                System.out.println(areFriends(x, y) ? 1 : 0);
                continue;
            } else if (c == 4) {
                System.out.println(areEnemies(x, y) ? 1 : 0);
            }
        }
    }

    private static void makeSet() {
        parent = new int[N * 2];
        rank = new int[N * 2];
        for (int i = 0; i < N * 2; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    private static boolean areFriends(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        return rootX == rootY;
    }

    private static boolean areEnemies(int x, int y) {
        int rootX = findSet(x);
        int rootYN = findSet(y + N);
        return rootX == rootYN;
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
