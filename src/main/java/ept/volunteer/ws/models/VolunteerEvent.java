package ept.volunteer.ws.models;

import javax.persistence.Id;

public class VolunteerEvent {

    @Id
    private Long volunteerEventId;

    private Long volunteerId;

    private Long eventId;

    public VolunteerEvent(Long volunteerEventId, Long volunteerId, Long eventId) {
        this.volunteerEventId = volunteerEventId;
        this.volunteerId = volunteerId;
        this.eventId = eventId;
    }

    public Long getVolunteerEventId() {
        return volunteerEventId;
    }

    public void setVolunteerEventId(Long volunteerEventId) {
        this.volunteerEventId = volunteerEventId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "VolunteerEvent{" +
                "volunteerEventId=" + volunteerEventId +
                ", volunteerId=" + volunteerId +
                ", eventId=" + eventId +
                '}';
    }
}
