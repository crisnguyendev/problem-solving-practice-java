package BigOCoding.Dijkstra.SendingEmail;

import java.util.*;

public class SendingEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();
        for (int i = 0; i < totalTestCases; i++) {
            int totalServers = scanner.nextInt();
            int totalCables = scanner.nextInt();
            int startServer = scanner.nextInt();
            int destinationServer = scanner.nextInt();
            List<List<Server>> adjServers = new ArrayList<>();
            for (int j = 0; j < totalServers; j++) {
                adjServers.add(new ArrayList<>());
            }
            for (int j = 0; j < totalCables; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int latency = scanner.nextInt();
                adjServers.get(x).add(new Server(y, latency));
                adjServers.get(y).add(new Server(x, latency));
            }
            int[] latency = dijkstra(startServer, totalServers, adjServers);
            String output = latency[destinationServer] == Integer.MAX_VALUE ? "unreachable" : String.valueOf(latency[destinationServer]);
            System.out.printf("Case #%d: %s\n", i + 1, output);
        }
    }

    private static int[] dijkstra(int start, int totalServer, List<List<Server>> adjServers) {
        int[] latency = new int[totalServer];
        Arrays.fill(latency, Integer.MAX_VALUE);
        PriorityQueue<Server> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Server(start, 0));
        latency[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Server currentServer = priorityQueue.poll();
            for (Server neighbor : adjServers.get(currentServer.id)) {
                int newLatency = latency[currentServer.id] + neighbor.latency;
                if (newLatency < latency[neighbor.id]) {
                    latency[neighbor.id] = newLatency;
                    priorityQueue.add(new Server(neighbor.id, newLatency));
                }
            }
        }
        return latency;
    }
}

class Server implements Comparable<Server> {
    int id;
    int latency;

    public Server(int id, int latency) {
        this.id = id;
        this.latency = latency;
    }

    @Override
    public int compareTo(Server server) {
        return latency - server.latency;
    }
}
