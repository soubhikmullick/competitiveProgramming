package calendarApp.entities;

import java.time.LocalDate;
import java.util.List;

public class Event {
    private int id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private List<User> userAttendees;
    private String eventType;

    public int getId() {
        return id;
    }

    public Event(int id) {
        this.id = id++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<User> getUserAttendees() {
        return userAttendees;
    }

    public void setUserAttendees(List<User> userAttendees) {
        this.userAttendees = userAttendees;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    private String printUserAttending(){
        StringBuilder sb = new StringBuilder();
        for(User user : getUserAttendees()) {
            sb.append(user.getId());
            sb.append(", ");
        }
        return sb.toString();
    }

    @Override public String toString() {
        return String.format("ID:"+getId()+"\n"+"Title:"+getTitle()+"\n"+"StartDate:"+getStartDate()+"\n"+"EndDate:"+getEndDate()+"\n"+"Location:"+getLocation()+"\n"+"Type:"+getEventType()+"\n"+"UsersAttending:"+printUserAttending());
    }
}
