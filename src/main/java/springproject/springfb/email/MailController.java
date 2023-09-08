package springproject.springfb.email;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/balmoa/reserve")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public ResponseEntity<String> sendEmailPath(@RequestBody HashMap<String,String> map) {
        mailService.sendMail(map.get("email"));
        return ResponseEntity.ok("이메일을 확인하세요");
    }

    @PostMapping("/mail/auth")
    public ResponseEntity<String> sendEmailAndCode(@RequestBody EmailDto emailDto){
        if(mailService.verifyEmailCode(emailDto.getEmail(),emailDto.getCode())){
            return ResponseEntity.ok("sucess");
        }
        return ResponseEntity.notFound().build();
    }
}
