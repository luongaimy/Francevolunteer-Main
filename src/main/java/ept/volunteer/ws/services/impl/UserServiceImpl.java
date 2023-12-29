package ept.volunteer.ws.services.impl;

import ept.volunteer.ws.models.UserLogin;
import ept.volunteer.ws.responsitory.UserLoginRepository;
import ept.volunteer.ws.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserLoginRepository userLoginRepository;

    @Override
    public List<UserLogin> findAllUsers() {
        return userLoginRepository.findAll();
    }
}
