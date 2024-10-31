package BigOCoding.DisjointSetUnion.LostAndSurvived;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LostAndSurvived {
    private static int N;
    private static int[] parent;
    private static int[] rank;
    private static int maxSize;
    private static PriorityQueue<Group> groupHeap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        makeSet();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            unionSet(x, y);
            updateMin();
            System.out.println(maxSize == N ? 0 : maxSize - groupHeap.peek().rank);
        }
    }

    private static void updateMin() {
        while (!groupHeap.isEmpty()) {
            Group group = groupHeap.peek();
            if (findSet(group.root) != group.root) {
                groupHeap.poll();
                continue;
            }
            if (group.rank != rank[group.root]) {
                groupHeap.poll();
                continue;
            }
            break;
        }
    }

    private static void makeSet() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        groupHeap = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;
            groupHeap.add(new Group(i, 1));
        }
        maxSize = 1;
    }


    private static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    private static void unionSet(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
            maxSize = Math.max(maxSize, rank[rootY]);
            groupHeap.add(new Group(rootY, rank[rootY]));
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
            maxSize = Math.max(maxSize, rank[rootX]);
            groupHeap.add(new Group(rootX, rank[rootX]));
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
            maxSize = Math.max(maxSize, rank[rootY]);
            groupHeap.add(new Group(rootY, rank[rootY]));
        }

    }
}

class Group implements Comparable<Group> {
    int root;
    int rank;

    Group(int root, int rank) {
        this.root = root;
        this.rank = rank;
    }

    @Override
    public int compareTo(Group group) {
        return rank - group.rank;
    }
}
