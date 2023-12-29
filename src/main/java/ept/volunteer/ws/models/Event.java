package ept.volunteer.ws.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "event")
public class Event {

    @Id
    private Long eventId;
    private String eventName;
    private String eventImg;
    private String eventStartTime;
    private String eventEndTime;
    private String duration;
    private String eventMissionType;
    private String eventAddress;
    private String postedDate;
    private String description;
    private String neededProfessionals;
    private String neededTimes;
    private String slotRemaining;
    private Integer eventPoints;
    private String eventStatus;

    public Event(Long eventId, String eventName, String eventImg, String eventStartTime, String eventEndTime,
                 String duration, String eventMissionType, String eventAddress, String postedDate, String description,
                 String neededProfessionals, String neededTimes, String slotRemaining, Integer eventPoints, String eventStatus) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventImg = eventImg;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.duration = duration;
        this.eventMissionType = eventMissionType;
        this.eventAddress = eventAddress;
        this.postedDate = postedDate;
        this.description = description;
        this.neededProfessionals = neededProfessionals;
        this.neededTimes = neededTimes;
        this.slotRemaining = slotRemaining;
        this.eventPoints = eventPoints;
        this.eventStatus = eventStatus;
    }

    public Event() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventImg() {
        return eventImg;
    }

    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEventMissionType() {
        return eventMissionType;
    }

    public void setEventMissionType(String eventMissionType) {
        this.eventMissionType = eventMissionType;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNeededProfessionals() {
        return neededProfessionals;
    }

    public void setNeededProfessionals(String neededProfessionals) {
        this.neededProfessionals = neededProfessionals;
    }

    public String getNeededTimes() {
        return neededTimes;
    }

    public void setNeededTimes(String neededTimes) {
        this.neededTimes = neededTimes;
    }

    public String getSlotRemaining() {
        return slotRemaining;
    }

    public void setSlotRemaining(String slotRemaining) {
        this.slotRemaining = slotRemaining;
    }

    public Integer getEventPoints() {
        return eventPoints;
    }

    public void setEventPoints(Integer eventPoints) {
        this.eventPoints = eventPoints;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventImg='" + eventImg + '\'' +
                ", eventStartTime='" + eventStartTime + '\'' +
                ", eventEndTime='" + eventEndTime + '\'' +
                ", duration='" + duration + '\'' +
                ", eventMissionType='" + eventMissionType + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", description='" + description + '\'' +
                ", neededProfessionals='" + neededProfessionals + '\'' +
                ", neededTimes='" + neededTimes + '\'' +
                ", slotRemaining='" + slotRemaining + '\'' +
                ", eventPoints='" + eventPoints + '\'' +
                ", eventStatus='" + eventStatus + '\'' +
                '}';
    }
}
