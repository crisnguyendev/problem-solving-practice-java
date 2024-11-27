package DSA.SlidingWindow.RepeatedDNASequences;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new OptimalSolution().findRepeatedDnaSequences(s));
    }
}


class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)

    public List<String> findRepeatedDnaSequences(String s) {
        int k = 10;
        if (s.length() <= k) {
            return new ArrayList<>();
        }
        int[] values = new int[s.length()];
        int base = 4;
        Map<Character, Integer> mapChar = new HashMap<>();
        mapChar.put('A', 1);
        mapChar.put('C', 2);
        mapChar.put('G', 3);
        mapChar.put('T', 4);
        for (int i = 0; i < values.length; i++) {
            values[i] = mapChar.get(s.charAt(i));
        }

        int hash = 0;
        Set<Integer> hashSet = new HashSet<>();
        Set<String> outputSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            hash += values[i] * (int) Math.pow(base, k - i - 1);
        }
        hashSet.add(hash);

        for (int i = 1; i < values.length - k + 1; i++) {
            int preHash = hash;
            hash = (preHash - values[i - 1] * (int) Math.pow(base, k - 1)) * base + values[i + k - 1];
            if (hashSet.contains(hash)) {
                outputSet.add(s.substring(i, i + k));
            } else {
                hashSet.add(hash);
            }
        }
        return new ArrayList<>(outputSet);
    }
}

class OptimalSolution {
    // Time complexity: O(n)
    // Space complexity: O(n) - Fixed size array to be used as hash map.

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return List.of();
        int val = 0;
        char[] dna = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            val *= 4;
            val += code(dna[i]);
        }
        var counter = new int[1048576];
        var result = new ArrayList<String>();
        counter[val] = 1;

        for (int i = 10; i < dna.length; i++) {
            int remove = code(dna[i - 10]);
            remove *= 262144;
            val -= remove;
            val *= 4;
            val += code(dna[i]);
            if ((counter[val] += 1) == 2) result.add(s.substring(i - 9, i + 1));
        }
        return result;
    }

    int code(char v) {
        switch (v) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}