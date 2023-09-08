package springproject.springfb.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balmoa")
public class UserController {
//    @Autowired
//    private EmailServiceImpl emailService;

    private final UserService userService;
//    @Autowired
    private UserRepository userRepository;

//    public UserController(EmailServiceImpl emailService) {
//        this.emailService = emailService;
//    }

    //    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @PostMapping(value="/main")
//    public ResponseEntity<String> mainPage(@RequestBody User user)throws Exception{
//        String meg = "학번 : "+user.getStudentId()+" 이름 : "+user.getName()+" 번호 : "+user.getPhone()+" 학과 : "+ user.getDepartment()+"가 생성되었습니다.";
//        String email = user.getStudentId()+"@yc.ac.kr";
//        emailService.sendSimpleMessage(email);
//        return ResponseEntity.ok(email);
//    }
//    @PathVariable("studentId") String studentId,@PathVariable("name") String name,
//    @PathVariable("phone") String phone,@PathVariable("department") String department

//    @GetMapping("/email")
//    public ResponseEntity sendEmail(){
//        return ResponseEntity.ok().build();
//    }
    @GetMapping
    public List<User> getReserve(){
        return userRepository.findAll();
    }
    @PostMapping("/reserve")
    public User setReserve(@Valid @RequestBody User user){
        return userRepository.save(user);
    }
}
