package ept.volunteer.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ept.volunteer.ws.models.Volunteer;
import ept.volunteer.ws.responsitory.VolunteerResponsitory;

@DataMongoTest
class VolunteerResponsitoryTest {

    @Autowired
    private VolunteerResponsitory volunteerResponsitory;

    @MockBean
    private VolunteerResponsitory volunteerResponsitoryMock;

    @BeforeEach
    void setUp() {
        Volunteer volunteer = new Volunteer();
        volunteer.setVolunteerId(4259541883735984667L); //here is a volunteer id in local db
        volunteer.setEmail("hung1@gmail.com"); //here is a volunteer email in local db

        // Mock the methods of the repository
        when(volunteerResponsitoryMock.findByVolunteerId(any(Long.class))).thenReturn(Optional.of(volunteer));
        when(volunteerResponsitoryMock.findByEmail(any(String.class))).thenReturn(Optional.of(volunteer));
    }

    @Test
    void testFindByVolunteerId() {
        Long volunteerId = 4259541883735984667L;
        Optional<Volunteer> volunteer = volunteerResponsitory.findByVolunteerId(volunteerId);

        assertThat(volunteer.isPresent()).isTrue();
        assertThat(volunteer.get().getVolunteerId()).isEqualTo(volunteerId);
    }

    @Test
    void testFindByEmail() {
        String email = "hung1@gmail.com";
        Optional<Volunteer> volunteer = volunteerResponsitory.findByEmail(email);

        assertThat(volunteer.isPresent()).isTrue();
        assertThat(volunteer.get().getEmail()).isEqualTo(email);
    }
}


