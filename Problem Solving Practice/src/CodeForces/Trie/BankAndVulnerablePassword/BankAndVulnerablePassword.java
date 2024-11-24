package CodeForces.Trie.BankAndVulnerablePassword;

import java.util.Scanner;

public class BankAndVulnerablePassword {
    private static final int ALPHABET_SIZE = 26;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfUsers = scanner.nextInt();
        Node rootNode = new Node();
        int i = 0;
        boolean isVulnerable = false;
        while (!isVulnerable && i < numberOfUsers) {
            String password = scanner.next();
            isVulnerable = isVulnerable(rootNode, password);
            i++;
        }
        System.out.println(isVulnerable? "vulnerable": "non vulnerable");
    }

    private static boolean isVulnerable(Node root, String password) {
        Node temp = root;
        for (char c : password.toCharArray()) {
            int position = c - 'a';
            if (temp.children[position] == null) {
                temp.children[position] = new Node();
            }
            temp = temp.children[position];
            temp.charCount++;
            if (temp.wordCount > 0) {
                return true;
            }
        }
        temp.wordCount++;
        return temp.charCount > 1;
    }

    static class Node {
        Node[] children;
        int wordCount;
        int charCount;

        public Node() {
            children = new Node[ALPHABET_SIZE];
        }
    }
}
