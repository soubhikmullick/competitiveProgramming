package calendarApp.controllers;

import calendarApp.entities.User;

import java.util.List;
import java.util.Optional;

public class CalendarController {
    public void getUserMeetings(int userId, List<User> userList) {
        Optional<User> user = userList.stream().filter(s -> s.getId()==userId).findFirst();
        if(user.isPresent()) {
            user.get().getCalendar().getEvent().forEach(System.out::println);
        } else {
            System.out.println("No such user exists");
        }
    }

    public void getInviteeResponse(int meetingId, List<User> userList) {
        Optional<User> user = userList.stream().filter(s -> s.getCalendar().getEvent().get(meetingId).getId()==meetingId).findFirst();
        if(user.isPresent()) {
            List<User> attendees = user.get().getCalendar().getEvent().get(meetingId).getUserAttendees();
            System.out.println(attendees);

        } else {
            System.out.println("No such event exists");
        }
    }
}
