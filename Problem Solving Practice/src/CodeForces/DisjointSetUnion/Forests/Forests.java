package CodeForces.DisjointSetUnion.Forests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Forests {
    private static int P;
    private static int T;
    private static int[] parent;
    private static int[] rank;
    private static Set<Integer>[] heardTreesByPeople;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            P = scanner.nextInt();
            T = scanner.nextInt();
            makeSet();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;
                String[] input = line.split(" ");
                int person = Integer.parseInt(input[0]);
                int tree = Integer.parseInt(input[1]);
                heardTreesByPeople[person].add(tree);
            }
            groupPeople();
            System.out.println(getNumberOfGroups());
            if (n > 0) {
                System.out.println();
            }
        }
    }

    private static void makeSet() {
        parent = new int[P + 1];
        rank = new int[P + 1];
        heardTreesByPeople = new Set[P + 1];
        for (int i = 1; i <= P; i++) {
            parent[i] = i;
            rank[i] = 0;
            heardTreesByPeople[i] = new HashSet<>();
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
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    private static void groupPeople() {
        for (int i = 1; i <= P; i++) {
            for (int j = i + 1; j <= P; j++) {
                if (heardTreesByPeople[i].equals(heardTreesByPeople[j])) {
                    unionSet(i, j);
                }
            }
        }
    }

    private static int getNumberOfGroups() {
        int count = 0;
        for (int i = 1; i <= P; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
}
