package DSA.TwoHeap.MeetingRoomsIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] bookings = new int[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<int[]> inUseRooms = new PriorityQueue<>((a, b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]); // sort by end time then room index
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // sort by start time
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        int maxBooking = 0;
        for (int[] meeting : meetings) {
            while (!inUseRooms.isEmpty() && inUseRooms.peek()[1] <= meeting[0]) {
                availableRooms.add(inUseRooms.poll()[0]);
            }
            if (!availableRooms.isEmpty()) {
                int availableRoomNumber = availableRooms.poll();
                inUseRooms.add(new int[]{availableRoomNumber, meeting[1]});
                bookings[availableRoomNumber]++;
                maxBooking = Math.max(maxBooking, bookings[availableRoomNumber]);
            } else {
                int[] earliestRoom = inUseRooms.poll();
                earliestRoom[1] = earliestRoom[1] + meeting[1] - meeting[0];
                inUseRooms.add(earliestRoom);
                bookings[earliestRoom[0]]++;
                maxBooking = Math.max(maxBooking, bookings[earliestRoom[0]]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (bookings[i] == maxBooking)
                return i;
        }
        return -1;
    }
}