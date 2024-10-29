package BigOCoding.BinarySearchTree.HardwoodSpecies;

import java.util.Scanner;
import java.util.TreeMap;

public class HardwoodSpecies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestcases = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < totalTestcases; i++) {
            int count = 0;
            TreeMap<String, Integer> treeMap = new TreeMap<>();
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.isEmpty())
                    break;
                if (treeMap.containsKey(input)) {
                    treeMap.put(input, treeMap.get(input) + 1);
                } else {
                    treeMap.put(input, 1);
                }
                count++;
            }
            for (String key : treeMap.keySet()) {
                System.out.printf("%s %.4f\n", key, (double) treeMap.get(key) * 100 / count);
            }
        }
    }
}
