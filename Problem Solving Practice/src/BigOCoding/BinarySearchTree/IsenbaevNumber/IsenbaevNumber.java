package BigOCoding.BinarySearchTree.IsenbaevNumber;

import java.util.*;

public class IsenbaevNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String startName = "Isenbaev";
        int totalTeams = scanner.nextInt();
        List<List<Integer>> teamates = new ArrayList<>();
        for (int j = 0; j <= totalTeams * 3; j++) {
            teamates.add(new ArrayList<>());
        }

        Map<String, Integer> map = new TreeMap<>();
        int id = 1;
        for (int i = 0; i < totalTeams; i++) {
            String member1 = scanner.next();
            String member2 = scanner.next();
            String member3 = scanner.next();
            if (!map.containsKey(member1)) {
                map.put(member1, id);
                id++;
            }
            if (!map.containsKey(member2)) {
                map.put(member2, id);
                id++;
            }
            if (!map.containsKey(member3)) {
                map.put(member3, id);
                id++;
            }
            teamates.get(map.get(member1)).add(map.get(member2));
            teamates.get(map.get(member2)).add(map.get(member1));
            teamates.get(map.get(member2)).add(map.get(member3));
            teamates.get(map.get(member3)).add(map.get(member2));
            teamates.get(map.get(member1)).add(map.get(member3));
            teamates.get(map.get(member3)).add(map.get(member1));
        }
        int[] numbers = bfs(map.get(startName) == null ? 0 : map.get(startName), id, teamates);
        for (String name : map.keySet()) {
            String number = numbers[map.get(name)] == -1 ? "undefined" : String.valueOf(numbers[map.get(name)]);
            System.out.println(name + " " + number);
        }
    }

    private static int[] bfs(int start, int totalPeople, List<List<Integer>> teamates) {
        boolean[] visited = new boolean[totalPeople];
        int[] numbers = new int[totalPeople];
        Arrays.fill(numbers, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        numbers[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            for (int teamate : teamates.get(current)) {
                if (!visited[teamate]) {
                    numbers[teamate] = numbers[current] + 1;
                    visited[teamate] = true;
                    queue.add(teamate);
                }
            }
        }
        return numbers;
    }
}