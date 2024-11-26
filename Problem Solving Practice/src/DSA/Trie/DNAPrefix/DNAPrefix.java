package DSA.Trie.DNAPrefix;

import java.util.Scanner;

public class DNAPrefix {
    private static final int ALPHABET_SIZE = 26;
    private static int maxResult;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            Trie trie = new Trie();
            maxResult = 0;
            int numberOfSamples = scanner.nextInt();
            for (int j = 0; j < numberOfSamples; j++) {
                String sample = scanner.next();
                addWord(trie, sample);
            }
            System.out.printf("Case %d: %d\n", i + 1, maxResult);
        }
    }

    private static void addWord(Trie trie, String word) {
        Node temp = trie.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'A'] == null) {
                temp.children[c - 'A'] = new Node();
            }
            temp = temp.children[c - 'A'];
            temp.weight++;
            maxResult = Math.max(maxResult, temp.weight * (i + 1));
        }

    }

    static class Node {
        Node[] children;
        int weight;

        public Node() {
            children = new Node[ALPHABET_SIZE];
            weight = 0;
        }
    }

    static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
    }
}
