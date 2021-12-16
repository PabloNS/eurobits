package es.care.sf.scenariosystem.service;

import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
