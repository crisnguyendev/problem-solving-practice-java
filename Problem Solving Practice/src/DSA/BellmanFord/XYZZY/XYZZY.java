package DSA.BellmanFord.XYZZY;

import java.util.*;

public class XYZZY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == -1)
                break;
            List<DoorWay> doorWays = new ArrayList<>();
            for (int in = 1; in <= n; in++) {
                int energy = scanner.nextInt();
                int numberOfDoorways = scanner.nextInt();
                for (int j = 0; j < numberOfDoorways; j++) {
                    int out = scanner.nextInt();
                    doorWays.add(new DoorWay(in, out, energy));
                }
            }
            System.out.println(canReachToDestination(1, n, doorWays) ? "winnable" : "hopeless");
        }
    }

    private static boolean canReachToDestination(int start, int totalRooms, List<DoorWay> doorWays) {
        int[] remainingEnergy = new int[totalRooms + 1];
        Arrays.fill(remainingEnergy, Integer.MIN_VALUE);
        remainingEnergy[start] = 100;
        for (int i = 0; i < totalRooms - 1; i++) {
            for (DoorWay doorWay : doorWays) {
                if (remainingEnergy[doorWay.in] > 0) {
                    remainingEnergy[doorWay.out] = Math.max(remainingEnergy[doorWay.in] + doorWay.energy, remainingEnergy[doorWay.out]);
                }
            }
        }

        for (DoorWay doorWay : doorWays) {
            if (remainingEnergy[doorWay.in] > 0 && remainingEnergy[doorWay.in] + doorWay.energy > remainingEnergy[doorWay.out] && existPath(start, totalRooms, totalRooms, doorWays)) {
                return true;
            }
        }

        return remainingEnergy[totalRooms] > 0;
    }

    private static boolean existPath(int start, int destination, int totalRooms, List<DoorWay> doorWays) {
        boolean[] visited = new boolean[totalRooms + 1];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (DoorWay doorWay : doorWays) {
                if (doorWay.in != current)
                    continue;
                if (!visited[doorWay.out]) {
                    queue.add(doorWay.out);
                    visited[doorWay.out] = true;
                }
                if (doorWay.out == destination)
                    return true;

            }
        }
        return false;
    }
}

class DoorWay {
    int in;
    int out;
    int energy;

    public DoorWay(int in, int out, int energy) {
        this.in = in;
        this.out = out;
        this.energy = energy;
    }
}
