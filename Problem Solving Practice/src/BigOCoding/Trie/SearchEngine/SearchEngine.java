package BigOCoding.Trie.SearchEngine;

import java.util.Scanner;

public class SearchEngine {
    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDatabases = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < numberOfDatabases; i++) {
            String word = scanner.next();
            int weight = scanner.nextInt();
            addWord(trie, word, weight);
        }
        for (int i = 0; i < numberOfQueries; i++) {
            String query = scanner.next();
            System.out.println(getHighestWeight(trie, query));
        }
    }

    static class Node {
        Node[] children;
        int maxWeight;

        public Node() {
            children = new Node[ALPHABET_SIZE];
            maxWeight = -1;
        }
    }

    static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
    }

    private static void addWord(Trie trie, String word, int weight) {
        Node temp = trie.root;
        for(Character c : word.toCharArray()) {
            if(temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Node();
            }
            temp = temp.children[c - 'a'];
            temp.maxWeight = Math.max(temp.maxWeight, weight);
        }
    }

    private static int getHighestWeight(Trie trie, String word) {
        Node temp = trie.root;
        for(Character c : word.toCharArray()) {
            if(temp.children[c - 'a'] == null) {
                return -1;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.maxWeight;
    }
}


