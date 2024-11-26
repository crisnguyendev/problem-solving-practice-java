package DSA.BinarySearchTree.TanyaPostcard;

import java.util.Scanner;
import java.util.TreeMap;

public class TanyaPostcard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String requiredMessage = scanner.nextLine();
        String newspaperText = scanner.nextLine();
        TreeMap<Character, Integer> givenCharMap = new TreeMap<>();
        TreeMap<Character, Integer> requiredCharMap = new TreeMap<>();
        for (Character c : requiredMessage.toCharArray()) {
            if (requiredCharMap.containsKey(c)) {
                requiredCharMap.put(c, requiredCharMap.get(c) + 1);
            } else {
                requiredCharMap.put(c, 1);
            }
        }
        for (Character c : newspaperText.toCharArray()) {
            if (givenCharMap.containsKey(c)) {
                givenCharMap.put(c, givenCharMap.get(c) + 1);
            } else {
                givenCharMap.put(c, 1);
            }
        }

        int yayCount = 0;
        int whoopsCount = 0;
        for (Character requiredChar : requiredCharMap.keySet()) {
            int requiredCharCount = requiredCharMap.get(requiredChar);
            int givenCharCount = givenCharMap.get(requiredChar) == null ? 0 : givenCharMap.get(requiredChar);
            if (requiredCharCount <= givenCharCount) {
                yayCount += requiredCharCount;
            } else {
                yayCount += givenCharCount;
                whoopsCount += requiredCharCount - givenCharCount;
            }
        }
        System.out.println(yayCount + " " + whoopsCount);
    }
}
