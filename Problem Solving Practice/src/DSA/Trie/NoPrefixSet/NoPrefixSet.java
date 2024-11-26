package DSA.Trie.NoPrefixSet;

import java.util.Scanner;

public class NoPrefixSet {
    private static final int ALPHABET_SIZE = 26;
    private static String failure;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = scanner.nextInt();
        boolean isGoodSet = true;
        Node rootNode = new Node();
        int i = 0;
        failure = "";
        while (isGoodSet && i < numberOfStrings) {
            String input = scanner.next();
            isGoodSet = addWord(rootNode, input);
            i++;
        }
        if (isGoodSet) {
            System.out.println("GOOD SET");
        } else {
            System.out.println("BAD SET");
            System.out.println(failure);
        }
    }

    private static boolean addWord(Node root, String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int position = c - 'a';
            if (temp.children[position] == null) {
                temp.children[position] = new Node();
            }
            temp = temp.children[position];
            temp.charCount++;
            if (temp.wordCount > 0) {
                failure = word;
                return false;
            }
        }
        temp.wordCount++;
        if (temp.charCount > 1) {
            failure = word;
            return false;
        }


        return true;
    }

    static class Node {
        Node[] children = new Node[ALPHABET_SIZE];
        int wordCount;
        int charCount;

        public Node() {
            children = new Node[ALPHABET_SIZE];
            wordCount = 0;
            charCount = 0;
        }
    }
}
