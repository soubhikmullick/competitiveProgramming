package calendarApp.entities;

import java.util.List;

public class Calendar {
    private List<Event> event;

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
