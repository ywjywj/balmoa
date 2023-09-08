package springproject.springfb.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springproject.springfb.email.MailService;

import java.util.List;

@RestController
@RequestMapping(value="/balmoa")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> GetAllUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/save")
    public ResponseEntity<User> save(User user){
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }
}