package ept.volunteer.ws.services;

import ept.volunteer.ws.models.UserLogin;

import java.util.List;

public interface UserService {
    List<UserLogin> findAllUsers();
}
