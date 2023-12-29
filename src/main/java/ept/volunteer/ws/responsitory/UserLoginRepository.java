package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLoginRepository extends MongoRepository<UserLogin, Long> {

    Boolean existsByEmail(String email);

    Optional<UserLogin> findByEmail(String email);

    Optional<UserLogin> findByUserId(Long userId);

    List<UserLogin> findAll();

}
