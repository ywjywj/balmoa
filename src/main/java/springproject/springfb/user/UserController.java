package springproject.springfb.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/balmoa/")
    public ResponseEntity login(){
        return ResponseEntity.ok().build();
    }

}
