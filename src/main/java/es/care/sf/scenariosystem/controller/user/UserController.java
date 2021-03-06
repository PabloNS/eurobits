package es.care.sf.scenariosystem.controller.user;

import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id){
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }
}
