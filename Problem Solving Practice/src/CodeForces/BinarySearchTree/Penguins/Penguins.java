package CodeForces.BinarySearchTree.Penguins;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Penguins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalEntries = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < totalEntries; i++) {
            String name = scanner.nextLine();
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }
        int maxCount = 0;
        String maxKind = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxKind = entry.getKey();
            }
        }
        System.out.println(maxKind);
    }
}
