package calendarApp.service;

import calendarApp.entities.Calendar;
import calendarApp.entities.Event;
import calendarApp.entities.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    public void addDefaultUserDetails(List<User> userList) {
        int eventId = 0;
        User user = new User();
        user.setId(1);
        Calendar calendar = new Calendar();
        LocalDate startDate = LocalDate.of(2019, Month.JANUARY, 20);
        LocalDate endDate = LocalDate.of(2019, Month.JANUARY, 30);
        Event event = getEvent(eventId, startDate, endDate, "Meeting", "Walmart Meeting", "ORR");

        LocalDate startDate1 = LocalDate.of(2019, Month.JANUARY, 10);
        LocalDate endDate1 = LocalDate.of(2019, Month.JANUARY, 11);
        Event event1 =
                getEvent(eventId, startDate1, endDate1, "Birthday", "Wife's birthday",
                        "Home");
        List<Event> events = new ArrayList<>();
        events.add(event);
        events.add(event1);
        calendar.setEvent(events);
        user.setCalendar(calendar);
        userList.add(user);
    }

    private Event getEvent(int eventId, LocalDate startDate, LocalDate endDate, String eventType, String title,
            String location) {

        List<User> userList = getUsersDefaultData();

        Event event = new Event(++eventId);
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setEventType(eventType);
        event.setTitle(title);
        event.setLocation(location);
        event.setUserAttendees(userList);
        return event;
    }

    private List<User> getUsersDefaultData() {
        User user = new User();
        user.setId(2);
        user.setResponse("Accepted");

        User user1 = new User();
        user1.setId(3);
        user1.setResponse("Accepted");

        User user2 = new User();
        user2.setId(4);
        user2.setResponse("Declined");

        User user3 = new User();
        user3.setId(5);
        user3.setResponse("Neutral");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    public void addEventToUsersCalendar(int userId, Event event, List<User> userList) {
        Optional<User> user = userList.stream().filter(s->s.getId()==userId).findFirst();
        if(user.isPresent()) {
//            Event even
            if(user.get().getCalendar().getEvent().stream().filter(s->s.getId()==event.getId()).count()==1) {

            }
        } else {
            System.out.println("Invalid User");
        }
    }
}
