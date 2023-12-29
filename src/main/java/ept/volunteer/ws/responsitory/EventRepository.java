package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, Long> {

    Optional<Event> findByEventId(Long eventId);

    List<Event> findAllByEventId(List<Long> eventIds);

}
