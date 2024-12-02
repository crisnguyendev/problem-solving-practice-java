package DSA.TwoHeap.MeetingRoomII;

import java.util.PriorityQueue;

public class MeetingRoomII {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 5}, {8, 9}, {8, 9}};
        Solution solution = new Solution();
        System.out.println(solution.minMeetingRooms(intervals));
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Room {
    int end;
    int id;

    public Room(int end, int id) {
        this.end = end;
        this.id = id;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Meeting> meetingHeap = new PriorityQueue<>((a, b) -> a.start - b.start);
        PriorityQueue<Room> roomsHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        int n = intervals.length;
        for (int[] meeting : intervals) {
            meetingHeap.add(new Meeting(meeting[0], meeting[1]));
        }
        if (meetingHeap.isEmpty())
            return 0;
        int rooms = 1;
        Meeting firstMeeting = meetingHeap.poll();
        roomsHeap.add(new Room(firstMeeting.end, rooms));
        while (!meetingHeap.isEmpty()) {
            Meeting nextMeeting = meetingHeap.poll();
            if (!roomsHeap.isEmpty() && roomsHeap.peek().end <= nextMeeting.start) {
                Room availableRoom = roomsHeap.poll();
                availableRoom.end = nextMeeting.end;
                roomsHeap.add(availableRoom);
            } else {
                rooms++;
                roomsHeap.add(new Room(nextMeeting.end, rooms));
            }
        }
        return rooms;
    }
}