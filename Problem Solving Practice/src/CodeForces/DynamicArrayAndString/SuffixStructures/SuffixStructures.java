package CodeForces.DynamicArrayAndString.SuffixStructures;

import java.util.Scanner;

class SuffixStructures {

    public static final String NEED_TREE = "need tree";
    public static final String ARRAY = "array";
    public static final String AUTOMATON = "automaton";
    public static final String BOTH = "both";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(checkSuffix(s, t));
    }

    public static String checkSuffix(String s, String t) {
        int[] countCharinS = new int[26];
        int[] countCharinT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countCharinS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            countCharinT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countCharinS[i] < countCharinT[i]) {
                return NEED_TREE;
            }
        }

        if (s.length() == t.length()) {
            return ARRAY;
        }

        int lastMatchIndex = -1;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = s.indexOf(c, lastMatchIndex + 1);
            if (index == -1) {
                return BOTH;
            } else {
                lastMatchIndex = index;
            }
        }

        return AUTOMATON;
    }
}
