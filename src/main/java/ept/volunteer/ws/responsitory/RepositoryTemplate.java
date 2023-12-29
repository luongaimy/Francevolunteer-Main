package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.models.UserLogin;
import ept.volunteer.ws.models.Volunteer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryTemplate {

    private final MongoTemplate mongoTemplate;

    public RepositoryTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void updateUserByUserId(Long userId, UserLogin userLogin) {
        Query query = new Query(Criteria.where("userId").is(userId));
        Update update = new Update()
                .set("status", userLogin.getStatus());

        mongoTemplate.updateFirst(query, update, UserLogin.class);
    }

    public void deleteUserByUserId(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, UserLogin.class);
    }

    public void deleteEventByEventId(Long eventId) {
        Query query = new Query(Criteria.where("eventId").is(eventId));
        mongoTemplate.remove(query, Event.class);
    }

    public void updateEventByEventId(Long eventId, Event event) {
        Query query = new Query(Criteria.where("eventId").is(eventId));
        Update update = new Update()
                .set("eventName", event.getEventName())
                .set("eventImg", event.getEventImg())
                .set("eventStartTime", event.getEventStartTime())
                .set("eventEndTime", event.getEventEndTime())
                .set("duration", event.getDuration())
                .set("eventMissionType", event.getEventMissionType())
                .set("eventAddress", event.getEventAddress())
                .set("postedDate", event.getPostedDate())
                .set("description", event.getDescription())
                .set("neededProfessionals", event.getNeededProfessionals())
                .set("neededTimes", event.getNeededTimes())
                .set("slotRemaining", event.getSlotRemaining())
                .set("eventPoints", event.getEventPoints())
                .set("eventStatus", event.getEventStatus());

        mongoTemplate.updateFirst(query, update, Event.class);
    }

    public void deleteVolunteerByVolunteerId(Long volunteerId) {
        Query query = new Query(Criteria.where("volunteerId").is(volunteerId));
        mongoTemplate.remove(query, Volunteer.class);
    }

    public void updateVolunteerByVolunteerId(Volunteer volunteer) {
        Query query = new Query(Criteria.where("volunteerId").is(volunteer.getVolunteerId()));
        Update update = new Update()
                .set("gender", volunteer.getGender())
                .set("firstName", volunteer.getFirstName())
                .set("lastName", volunteer.getLastName())
                .set("dob", volunteer.getDob())
                .set("address", volunteer.getAddress())
                .set("postalCode", volunteer.getPostalCode())
                .set("city", volunteer.getCity())
                .set("country", volunteer.getCountry())
                .set("phoneNumber", volunteer.getPhoneNumber())
                .set("actionArea", volunteer.getActionArea())
                .set("missionType", volunteer.getMissionType())
                .set("availability", volunteer.getAvailability())
                .set("professionalSituation", volunteer.getProfessionalSituation())
                .set("professionalDetail", volunteer.getProfessionalDetail())
                .set("possiableDisplacement", volunteer.getPossiableDisplacement())
                .set("travelType", volunteer.getTravelType())
                .set("email", volunteer.getEmail())
                .set("privacyRequiredRule", volunteer.getPrivacyRequiredRule())
                .set("privacyGetPromotion", volunteer.getPrivacyGetPromotion());

        mongoTemplate.updateFirst(query, update, Volunteer.class);
    }

    public List<Event> findEventsByEventIds(List<Long> eventIds) {
        Query query = Query.query(Criteria.where("eventId").in(eventIds));
        return mongoTemplate.find(query, Event.class);
    }

}
