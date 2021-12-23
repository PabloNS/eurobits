package es.care.sf.scenariosystem.service.user;

import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

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

    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(userDb -> {
                    userDb.setScenarioEurobitsId(user.getScenarioEurobitsId());
                    return userRepository.save(userDb);
                })
                .orElseGet(() -> {
                    log.error("User with id {} not found", id);
                    StringBuilder exceptionMessage = new StringBuilder("User with id ").append(id)
                            .append(" not found");
                    throw new CustomException(exceptionMessage.toString());
                });
    }
}
