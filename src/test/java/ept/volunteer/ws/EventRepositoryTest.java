package ept.volunteer.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.responsitory.EventRepository;

@DataMongoTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @MockBean
    private EventRepository eventRepositoryMock;

    @BeforeEach
    void setUp() {
        Event event = new Event();
        event.setEventId(1460105175836347482L); // here is an event id in local db

        // Mock the methods of the repository
        when(eventRepositoryMock.findByEventId(any(Long.class))).thenReturn(Optional.of(event));

        List<Event> events = new ArrayList<>();
        events.add(event);
        when(eventRepositoryMock.findAllByEventId(any(List.class))).thenReturn(events);
    }

    @Test
    void testFindByEventId() {
        Long eventId = 1460105175836347482L;
        Optional<Event> event = eventRepository.findByEventId(eventId);

        assertThat(event.isPresent()).isTrue();
        assertThat(event.get().getEventId()).isEqualTo(eventId);
    }

    @Test
    void testFindAllByEventId() {
        Long eventId = 1460105175836347482L;
        List<Long> eventIds = new ArrayList<>();
        eventIds.add(eventId);

        List<Event> events = eventRepository.findAllByEventId(eventIds);

        assertThat(events).isNotEmpty();
        assertThat(events.size()).isEqualTo(1);
        assertThat(events.get(0).getEventId()).isEqualTo(eventId);
    }
}
