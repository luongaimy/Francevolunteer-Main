package ept.volunteer.ws.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ept.volunteer.ws.common.Constant;
import ept.volunteer.ws.models.UserLogin;
import ept.volunteer.ws.requestpayload.request.UserRequest;
import ept.volunteer.ws.requestpayload.response.ResponseData;
import ept.volunteer.ws.responsitory.UserLoginRepository;
import ept.volunteer.ws.responsitory.RepositoryTemplate;
import ept.volunteer.ws.security.JwtUtils;
import ept.volunteer.ws.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Admin", description = "Admin management APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("/frvol/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    UserLoginRepository userRepository;

    @Autowired
    RepositoryTemplate userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/userList")
    public ResponseData getUserList() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);
        responseData.setData(objectMapper.writeValueAsString(userService.findAllUsers()));
        return responseData;

    }

    @PostMapping("/userDetail")
    public ResponseData getUserDetail(@RequestBody UserRequest userRequest) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        Optional<UserLogin> userLogin = userRepository.findByUserId(Long.parseLong(userRequest.getId()));

        if (userLogin.isPresent())
            responseData.setData(objectMapper.writeValueAsString(userLogin.get()));
        else
            responseData.setData(objectMapper.writeValueAsString(Constant.BLANK));
        return responseData;
    }

    @PostMapping("/changeStatus")
    public ResponseData changeUserStatus(@RequestBody UserRequest userRequest) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        Optional<UserLogin> userLogin = userRepository.findByUserId(Long.parseLong(userRequest.getId()));
        if (userLogin.isPresent()) {
            UserLogin userExistedLogin = userLogin.get();
            userExistedLogin.setStatus(userRequest.getStatus());
            userRepo.updateUserByUserId(userExistedLogin.getUserId(), userExistedLogin);
        } else {
            responseData.setCode(Constant.RESPONSE_CODE_404);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

    @PostMapping("/delete")
    public ResponseData deleteUser(@RequestBody UserRequest userRequest) {

        ResponseData responseData = new ResponseData();
        responseData.setCode(Constant.RESPONSE_CODE_200);
        responseData.setMessage(Constant.RESPONSE_MESSAGE_OK);

        try {
            userRepo.deleteUserByUserId(Long.parseLong(userRequest.getId()));
        } catch (Exception e) {
            responseData.setCode(Constant.RESPONSE_CODE_500);
            responseData.setMessage(Constant.RESPONSE_MESSAGE_NOT_OK);
        }

        responseData.setData(Constant.BLANK);
        return responseData;
    }

}
