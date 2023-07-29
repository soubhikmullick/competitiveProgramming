package phonepe2;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private List<LocalTime> shiftTimings;

    public List<String> getBusySlots() {
        return busySlots;
    }

    public void setBusySlots(final List<String> busySlots) {
        this.busySlots = busySlots;
    }

    private List<String> busySlots;
    private List<Event> events;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.shiftTimings = new ArrayList<>();
        this.busySlots = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void addShiftTiming(String shiftTiming) {
        LocalTime startTime = LocalTime.parse(shiftTiming.split("-")[0].trim(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(shiftTiming.split("-")[1].trim(), DateTimeFormatter.ofPattern("HH:mm"));
        shiftTimings.add(startTime);
        shiftTimings.add(endTime);
    }

    public List<LocalTime> getShiftTimings() {
        return shiftTimings;
    }

    public void addBusySlot(String busySlot) {
        busySlots.add(busySlot);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void createEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {
        events.remove(event);
    }
}
