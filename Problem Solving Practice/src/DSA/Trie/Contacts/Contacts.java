package DSA.Trie.Contacts;

import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node();
        int numberOfOperations = scanner.nextInt();
        for (int i = 0; i < numberOfOperations; i++) {
            String operation = scanner.next();
            String input = scanner.next();
            if (operation.equals("add")) {
                addWord(root, input);
            } else if (operation.equals("find")) {
                System.out.println(findWord(root, input));
            }
        }
    }

    private static void addWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (root.children[position] == null) {
                root.children[position] = new Node();
            }
            root = root.children[word.charAt(i) - 'a'];
            root.count++;
        }
    }

    private static int findWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (root.children[position] == null) {
                return 0;
            }
            root = root.children[position];
        }
        return root.count;
    }

    static class Node {
        Node[] children;
        int count;

        public Node() {
            children = new Node[26];
            count = 0;
        }
    }
}
