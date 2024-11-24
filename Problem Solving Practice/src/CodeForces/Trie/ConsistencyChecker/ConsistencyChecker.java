package CodeForces.Trie.ConsistencyChecker;

import java.util.Scanner;

public class ConsistencyChecker {
    private static boolean isConsistent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            Node root = new Node();
            isConsistent = true;
            int totalNumbers = scanner.nextInt();
            for (int j = 0; j < totalNumbers; j++) {
                String word = scanner.next();
                if (isConsistent) {
                    addWord(root, word);
                }
            }
            System.out.printf("Case %d: %s\n", i + 1, isConsistent ? "YES" : "NO");
        }
    }


    static class Node {
        Node[] children;
        int coundWord;

        public Node() {
            children = new Node[26];
            coundWord = 0;
        }
    }

    private static void addWord(Node root, String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {

            if (temp.children[word.charAt(i) - '0'] == null) {
                temp.children[word.charAt(i) - '0'] = new Node();
            } else if (i == word.length() - 1) {
                isConsistent = false;
                break;
            }
            if (temp.coundWord > 0) {
                isConsistent = false;
                break;
            }

            temp = temp.children[word.charAt(i) - '0'];
        }
        temp.coundWord++;
    }
}
