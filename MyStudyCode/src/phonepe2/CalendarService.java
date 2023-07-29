package phonepe2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CalendarService {
    private Map<String, User> users;
    private List<Event> events;

    public CalendarService() {
        this.users = new HashMap<>();
        this.events = new ArrayList<>();
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void deleteUser(String userId) {
        User user = users.remove(userId);
        if (user != null) {
            // Remove user's events
            events.removeIf(
                    event -> event.getOrganizerId().equals(userId) || event.getParticipantIds().contains(userId));
        }
    }

    public void createEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(String eventId, String userId) {
        Event eventToDelete = null;
        for (Event event : events) {
            if (event.getEventId().equals(eventId) && event.getOrganizerId().equals(userId)) {
                eventToDelete = event;
                break;
            }
        }
        if (eventToDelete != null) {
            events.remove(eventToDelete);
        }
    }

    // {start day - end day : start time end time}, {weekly, alternate days, bi-weekly, monthly, yearly}
    // User - id, name, eventIds
    // Event - id, start time, end time, occurrence,  - 100b x 1million 10mb
    // UserEventDet - userId, eventIds


    public Map<String, User> getUsers() {
        return users;
    }

    public List<Event> getEventsForUser(String userId) {
        List<Event> userEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getOrganizerId().equals(userId) || event.getParticipantIds().contains(userId)) {
                userEvents.add(event);
            }
        }
        return userEvents;
    }

    public List<Event> getConflictingEventsForUser(String userId, String date) {
        List<Event> conflictingEvents = new ArrayList<>();
        for (Event event : events) {
            if ((event.getOrganizerId().equals(userId) || event.getParticipantIds().contains(userId))
                    && event.getStartTime().startsWith(date)) {
                conflictingEvents.add(event);
            }
        }
        return conflictingEvents;
    }

    public List<Event> getUpcomingEmptySlot(List<String> userIds, String date, int durationInHours) {
        List<Event> emptySlots = new ArrayList<>();
        Map<String, List<LocalTime>> userShiftTimings = new HashMap<>();
        Map<String, List<String>> userBusySlots = new HashMap<>();

        // Get the shift timings and busy slots for each user on the specified date
        for (String userId : userIds) {
            User user = getUserById(userId);
            if (user != null) {
                List<LocalTime> shiftTimings = user.getShiftTimings();
                userShiftTimings.put(userId, shiftTimings);
                List<Event> userEvents = getEventsForUser(userId);
                List<String> busySlots = new ArrayList<>(user.getBusySlots()); // Copy user's busy slots

                for (Event event : userEvents) {
                    if (event.getStartTime().startsWith(date)) {
                        busySlots.add(event.getStartTime() + " - " + event.getEndTime());
                    }
                }

                userBusySlots.put(userId, busySlots);
            }
        }

        // Find the most favorable empty slot that can accommodate all participants and the specified duration
        String startTime = date + " 00:00";
        String endTime = date + " 23:59";
        for (String userId : userIds) {
            List<LocalTime> shiftTimings = userShiftTimings.get(userId);
            List<String> busySlots = userBusySlots.get(userId);

            for (LocalTime shiftStart : shiftTimings) {
                for (String slot : busySlots) {
                    LocalTime busyStartTime = LocalTime.parse(slot.split(" - ")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    LocalTime busyEndTime = LocalTime.parse(slot.split(" - ")[1]);

                    // Consider only the hours in the shift timings and ignore the date part
                    LocalTime adjustedShiftStart = shiftStart.withHour(Math.max(shiftStart.getHour(), busyEndTime.getHour()))
                            .withMinute(Math.max(shiftStart.getMinute(), busyEndTime.getMinute()));
                    LocalTime adjustedShiftEnd = shiftStart.withHour(Math.min(shiftStart.getHour(), busyStartTime.getHour()))
                            .withMinute(Math.min(shiftStart.getMinute(), busyStartTime.getMinute()));

                    if (adjustedShiftStart.isBefore(busyStartTime) || adjustedShiftStart.equals(busyStartTime)) {
                        if (adjustedShiftEnd.isBefore(busyStartTime) && endTime.compareTo(busyStartTime.toString()) >= 0 && startTime.compareTo(busyEndTime.toString()) <= 0) {
                            // There is a conflict with the busy slot, so update the startTime
                            startTime = busyEndTime.toString();
                        }
                    }
                }
            }
        }

        // Find the most favorable slot with the specified duration
        LocalDateTime favorableStartTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime favorableEndTime = favorableStartTime.plusHours(durationInHours);
        if (favorableEndTime.isAfter(LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))) {
            // The favorable slot with the duration exceeds the end time of the day
            return emptySlots; // Return an empty list as no favorable slot is available
        }

        emptySlots.add(new Event("Favorable Slot", "Organizer", userIds, favorableStartTime.toString(), favorableEndTime.toString()));
        return emptySlots;
    }
// for the shift timing -> remove all the busy slots (event slots + busy slots that user has input during shift
    // creation)


}
