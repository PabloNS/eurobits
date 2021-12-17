package es.care.sf.scenariosystem.service;

import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Long id) throws CustomException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            log.error("User with id {} not found", id);
            StringBuilder exceptionMessage = new StringBuilder("User with id ").append(id)
                    .append(" not found");
            throw new CustomException(exceptionMessage.toString());
        }
        return user.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
