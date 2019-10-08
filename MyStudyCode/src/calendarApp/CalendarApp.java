package calendarApp;

import calendarApp.controllers.CalendarController;
import calendarApp.entities.User;
import calendarApp.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class CalendarApp {

    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();
        CalendarController calendarController = new CalendarController();
        userService.addDefaultUserDetails(userList);

        calendarController.getUserMeetings(1, userList);

        calendarController.getInviteeResponse(1, userList);



    }
}
