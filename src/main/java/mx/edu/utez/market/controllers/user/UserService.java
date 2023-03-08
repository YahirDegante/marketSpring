package mx.edu.utez.market.controllers.user;

import mx.edu.utez.market.models.person.PersonRepository;
import mx.edu.utez.market.models.user.User;
import mx.edu.utez.market.models.user.UserRepository;
import mx.edu.utez.market.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<User>> findAll() {
        return new CustomResponse<>(
                this.userRepository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
