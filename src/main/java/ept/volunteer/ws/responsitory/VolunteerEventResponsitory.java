package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.models.Volunteer;
import ept.volunteer.ws.models.VolunteerEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VolunteerEventResponsitory extends MongoRepository<VolunteerEvent, Long> {

    Optional<VolunteerEvent> findByVolunteerId(Long volunteerId);

    @Query("{'volunteerId': ?0}")
    List<VolunteerEvent> findAllByVolunteerId(Long volunteerId);

}
