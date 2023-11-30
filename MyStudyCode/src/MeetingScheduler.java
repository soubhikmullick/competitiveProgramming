import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

class MeetingRoom {
    private String name;
    private List<Meeting> meetings;

    public MeetingRoom(String name) {
        this.name = name;
        this.meetings = new ArrayList<>();
    }

    public boolean bookMeeting(LocalTime startTime, LocalTime endTime) {
        // Check if the room is available during the requested time slot
        for (Meeting meeting : meetings) {
            if (startTime.isBefore(meeting.getEndTime()) && endTime.isAfter(meeting.getStartTime())) {
                System.out.println("Meeting room " + name + " is already booked during this time slot.");
                return false;
            }
        }

        // If the room is available, book the meeting
        meetings.add(new Meeting(startTime, endTime));
        System.out.println("Meeting room " + name + " booked from " + startTime + " to " + endTime);
        return true;
    }
}

public class MeetingScheduler {
    public static void main(String[] args) {
        MeetingRoom roomA = new MeetingRoom("Room A");
        MeetingRoom roomB = new MeetingRoom("Room B");

        roomA.bookMeeting(LocalTime.of(9, 0), LocalTime.of(10, 0));
        roomB.bookMeeting(LocalTime.of(11, 0), LocalTime.of(12, 30));
        roomA.bookMeeting(LocalTime.of(14, 0), LocalTime.of(15, 30));
        roomB.bookMeeting(LocalTime.of(10, 0), LocalTime.of(11, 0)); // Overlapping meeting
        roomB.bookMeeting(LocalTime.of(10, 30), LocalTime.of(11, 30)); // Overlapping meeting
    }
}
