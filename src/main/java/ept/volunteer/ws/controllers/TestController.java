package ept.volunteer.ws.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test", description = "A rest api test")
@RestController
@RequestMapping("/frvol/test")
public class TestController {

    @GetMapping("/hello")
    public String allAccess() {
        return "Hello. This is a Restfull API test!";
    }

}