package BigOCoding.Trie.DiccionarioPortunol;

import java.util.Scanner;

public class DiccionarioPortunol {
    private static final int ALPHABET_SIZE = 26;
    private static int[] startWith;
    private static int stateCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node prefixNode = new Node();
        Node suffixNode = new Node();
        startWith = new int[ALPHABET_SIZE];
        stateCount = 0;
        while (scanner.hasNext()) {
            int numberOfPortugueseWords = scanner.nextInt();
            int numberOfSpanishWords = scanner.nextInt();
            if (numberOfSpanishWords == 0 && numberOfPortugueseWords == 0)
                break;
            Node rootNode = new Node();
            for (int i = 0; i < numberOfPortugueseWords; i++) {
                String portugueseWord = scanner.next();
                addWord(prefixNode, portugueseWord);
            }
            for (int i = 0; i < numberOfSpanishWords; i++) {
                String spanishWord = new StringBuffer(scanner.next()).reverse().toString();
                addWord(suffixNode, spanishWord);
            }
            traverseSuffix(suffixNode, 0);
            stateCount--;
            long result = traversePrefix(prefixNode, 0);
            System.out.println(result);
        }
    }

    private static void addWord(Node rootNode, String word) {
        Node temp = rootNode;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (temp.children[position] == null) {
                temp.children[position] = new Node();
            }
            temp = temp.children[position];
        }
        temp.count++;
    }

    private static long traversePrefix(Node node, int level) {
        long result = 0;
        if (level > 0)
            result += stateCount;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] == null)
                continue;
            if (level > 0)
                result -= startWith[i];
            result += traversePrefix(node.children[i], level++);
        }
        return result;
    }

    private static void traverseSuffix(Node node, int level) {
        stateCount++;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if(node.children[i] == null)
                continue;
            if(level > 0)
                startWith[i]++;
            traverseSuffix(node.children[i], level++);
        }
    }

    static class Node {
        Node[] children;
        int count;

        public Node() {
            children = new Node[ALPHABET_SIZE];
            count = 0;
        }
    }

}
