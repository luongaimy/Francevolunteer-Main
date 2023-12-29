package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.CommonUtils;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.PayloadRequest;
import ept.volunteer.ws.models.Volunteer;
import ept.volunteer.ws.models.VolunteerEvent;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.responsitory.RepositoryTemplate;
import ept.volunteer.ws.responsitory.VolunteerEventResponsitory;
import ept.volunteer.ws.responsitory.VolunteerResponsitory;
import ept.volunteer.ws.security.JwtUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Volunteer", description = "Volunteer management APIs")
@RestController
@RequestMapping("/frvol/volunteer")
public class VolunteerController {

    private static final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    @Autowired
    VolunteerResponsitory volunteerResponsitory;

    @Autowired
    VolunteerEventResponsitory volunteerEventResponsitory;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RepositoryTemplate repositoryTemplate;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/profile/v1")
    public ResponseData getVolunteerProfile(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {

        logger.info(payloadRequest.toString());

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            Optional<Volunteer> volunteer = volunteerResponsitory.findByVolunteerId(payloadRequest.getId());

            if (volunteer.isPresent())
                responseData.setData(objectMapper.writeValueAsString(volunteer.get()));
            else
                responseData.setData(objectMapper.writeValueAsString(Constant.BLANK));
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        return responseData;
    }

    @PostMapping("/createVolunteer/v1")
    public ResponseData createVolunteer(@RequestBody Volunteer volunteer) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            String password = volunteer.getPassword();
            volunteer.setPassword(encoder.encode(password));

            volunteer.setVolunteerId(CommonUtils.generateRandomId());
            volunteerResponsitory.save(volunteer);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/updateVolunteer/v1")
    public ResponseData updateVolunteer(@RequestBody Volunteer volunteer) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            repositoryTemplate.updateVolunteerByVolunteerId(volunteer);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/deleteVolunteer/v1")
    public ResponseData deleteVolunteer(@RequestBody String volunteerId) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            repositoryTemplate.deleteVolunteerByVolunteerId(Long.parseLong(volunteerId));
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_500);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/getList/v1")
    public ResponseData getVolunteerList(@RequestBody PayloadRequest payloadRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(volunteerResponsitory.findAll()));
        return responseData;
    }

    @PostMapping("/createVolunteerEvent/v1")
    public ResponseData createVolunteerEvent(@RequestBody VolunteerEvent volunteerEvent) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            volunteerEventResponsitory.save(volunteerEvent);
        } catch (Exception e) {
            logger.error("Exception : {}", e.getMessage());
            responseData.setCode(Constant.RESPONSE_CODE_501);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

}
