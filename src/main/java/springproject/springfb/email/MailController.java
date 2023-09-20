package springproject.springfb.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Tag(name = "mail",description = "본교 학생 인증을 위한 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/balmoa/mail")
public class MailController {

    private final MailService mailService;

    @Operation(description = "이메일 인증을 위해 인증 코드 발급 API")
    @Parameter(name = "id",description = "학번 값",example = "12345678",required = true)
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "OK")
    })
    @PostMapping("")
    public ResponseEntity<String> sendEmailPath(@RequestBody HashMap<String,String> map) {
        String email = map.get("id")+"@st.yc.ac.kr";
        mailService.sendMail(email);
        return ResponseEntity.ok("이메일을 확인하세요");
    }

    @Operation(description = "인증 코드 검증 및 토큰 발급 API")
    @Parameters(value = {
        @Parameter(name = "code",description = "이메일로 받은 인증코드",required = true),
        @Parameter(name = "email",description = "멤버의 이메일 값",
                example ="12345678@st.yc.ac.kr" ,required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "success")
    })
    @PostMapping("/auth")
    public ResponseEntity<String> sendEmailAndCode(@RequestBody EmailDto emailDto){
        if(mailService.verifyEmailCode(emailDto.getEmail(),emailDto.getCode())){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.notFound().build();
    }
}
