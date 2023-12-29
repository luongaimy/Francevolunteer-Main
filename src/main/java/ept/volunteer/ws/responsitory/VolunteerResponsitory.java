package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VolunteerResponsitory extends MongoRepository<Volunteer, Long> {

    Optional<Volunteer> findByVolunteerId(Long volunteerId);

    Optional<Volunteer> findByEmail(String email);

}
