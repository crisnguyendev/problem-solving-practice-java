package BigOCoding.Trie.OldBerlandLanguage;

import java.util.*;

public class OldBerlandLanguage {
    private static final int MAX_CHILD_SIZE = 2;
    private static Map<Integer, List<String>> result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();
        result = new TreeMap<>();
        Node root = new Node();
        int[] lengths = new int[numberOfWords];
        int[] sortedLengths = new int[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            int length = scanner.nextInt();
            lengths[i] = length;
            sortedLengths[i] = length;
        }
        boolean existSet = true;
        Arrays.sort(sortedLengths);
        for (Integer length : sortedLengths) {
            if (!addWord(root, length)) {
                existSet = false;
                break;
            }
        }
        if (existSet) {
            System.out.println("YES");
            for (int i = 0; i < numberOfWords; i++) {
                List<String> list = result.get(lengths[i]);
                System.out.println(list.get(0));
                list.remove(0);
                result.put(lengths[i], list);
            }
        } else {
            System.out.println("NO");
        }

    }

    private static boolean addWord(Node root, int length) {
        Node node = root;
        Node parent;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int level = 1; level <= length; level++) {
            int nextChar = -1;
            for (int j = 0; j < MAX_CHILD_SIZE; j++) {
                if (node.children[j] == null) {
                    node.children[j] = new Node();
                }

                if (!node.children[j].isAvailable) {
                    continue;
                }

                nextChar = j;
                break;
            }
            if (nextChar == -1) {
                return false;
            } else {
                parent = node;
                node = node.children[nextChar];
                node.parent = parent;
                stringBuilder.append(nextChar);
            }
        }
        node.setUnavailable();
        List<String> list = result.getOrDefault(length, new ArrayList<>());
        list.add(stringBuilder.toString());
        result.put(length, list);
        return true;
    }

    static class Node {
        Node[] children;
        Node parent;
        boolean isAvailable;

        public Node() {
            children = new Node[MAX_CHILD_SIZE];
            isAvailable = true;
        }

        void setUnavailable() {
            isAvailable = false;
            validateParent();
        }

        private void validateParent() {
            if (parent == null) {
                return;
            }
            for (int i = 0; i < MAX_CHILD_SIZE; i++) {
                if (parent.children[i] == null || parent.children[i].isAvailable) {
                    return;
                }
            }
            parent.setUnavailable();
        }

    }
}
