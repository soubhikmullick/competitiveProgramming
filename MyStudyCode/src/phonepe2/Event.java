package phonepe2;

import java.util.List;

public class Event {
    private String eventId;
    private String organizerId;
    private List<String> participantIds;
    private String startTime;
    private String endTime;

    public Event(String eventId, String organizerId, List<String> participantIds, String startTime, String endTime) {
        this.eventId = eventId;
        this.organizerId = organizerId;
        this.participantIds = participantIds;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(final String eventId) {
        this.eventId = eventId;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(final String organizerId) {
        this.organizerId = organizerId;
    }

    public List<String> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(final List<String> participantIds) {
        this.participantIds = participantIds;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    // Getters and Setters for properties

    // Other methods as needed
}
