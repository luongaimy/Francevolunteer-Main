package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.CommonUtils;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.Event;
import ept.volunteer.ws.models.VolunteerEvent;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.responsitory.EventRepository;
import ept.volunteer.ws.responsitory.RepositoryTemplate;
import ept.volunteer.ws.responsitory.VolunteerEventResponsitory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name = "Event", description = "Event management APIs")
@RestController
@RequestMapping("/frvol/event")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VolunteerEventResponsitory volunteerEventResponsitory;

    @Autowired
    RepositoryTemplate repositoryTemplate;

    @PostMapping("/getDetail/v1")
    public ResponseData getEventDetail(@RequestBody String eventId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            Optional<Event> event = eventRepository.findByEventId(Long.parseLong(eventId));

            if (event.isPresent())
                responseData.setData(objectMapper.writeValueAsString(event.get()));
            else
                responseData.setData(objectMapper.writeValueAsString(Constant.BLANK));
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        return responseData;
    }

    @PostMapping("/getList/v1")
    public ResponseData getEventList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(eventRepository.findAll()));
        return responseData;
    }

    @PostMapping("/createEvent/v1")
    public ResponseData createEvent(@RequestBody Event event) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            event.setEventId(CommonUtils.generateRandomId());
            eventRepository.save(event);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/updateEvent/v1")
    @Operation(
            summary = "Update an event",
            description = "Updates an existing event",
            parameters = {
                    @Parameter(
                            name = "Authorization",
                            description = "Bearer Token",
                            required = true,
                            in = ParameterIn.HEADER,
                            schema = @Schema(type = "string")
                    ),
                    @Parameter(
                            name = "Content-Type",
                            description = "Request Content Type",
                            required = true,
                            in = ParameterIn.HEADER,
                            schema = @Schema(type = "string", defaultValue = "application/json")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseData updateEvent(@RequestBody Event event) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            repositoryTemplate.updateEventByEventId(event.getEventId(), event);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/deleteEvent/v1")
    public ResponseData deleteEvent(@RequestBody String eventId) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            repositoryTemplate.deleteEventByEventId(Long.parseLong(eventId));
        } catch (Exception e) {
            responseData.setCode(Constant.RESPONSE_CODE_500);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/getEventsByVolunteerId/v1")
    public ResponseData getEventsByVolunteerId(@RequestBody Long volunteerId) throws JsonProcessingException {
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Find all VolunteerEvents for the given volunteerId
            List<VolunteerEvent> volunteerEvents = volunteerEventResponsitory.findAllByVolunteerId(volunteerId);

            // Get the list of eventIds associated with the volunteer
            List<Long> eventIds = new ArrayList<>();
            for (VolunteerEvent volunteerEvent : volunteerEvents) {
                eventIds.add(volunteerEvent.getEventId());
            }

            // Find all events with the list of eventIds
            List<Event> events = repositoryTemplate.findEventsByEventIds(eventIds);

            responseData.setData(objectMapper.writeValueAsString(events));
        } catch (Exception e) {
            responseData.setCode(Constant.RESPONSE_CODE_500);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        return responseData;
    }

}
