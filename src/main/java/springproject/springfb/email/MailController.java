package springproject.springfb.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springproject.springfb.jwt.application.service.TokenService;
import springproject.springfb.jwt.domain.Token;

@Slf4j
@Tag(name = "mail",description = "본교 학생 인증을 위한 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/balmoa/mail")
public class MailController {

    private final MailService mailService;
    private final TokenService tokenService;

    @Operation(description = "이메일 인증을 위해 인증 코드 발급 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "성공"),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류")
    })
    @PostMapping("")
    public ResponseEntity<String> sendEmailPath(@RequestBody String id) {
        String email = id + "@st.yc.ac.kr";
        mailService.sendMail(email);
        return ResponseEntity.ok("이메일을 확인하세요");
    }

    @Operation(description = "인증 코드 검증 및 토큰 발급 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "성공"),
            @ApiResponse(responseCode = "500",description = "내부 서버 오류")
    })
    @PostMapping("/auth")
    public ResponseEntity<String> sendEmailAndCode(HttpServletResponse response,@RequestBody EmailDto emailDto){
        log.debug("[Email dto] : {},{}",emailDto.getEmail(),emailDto.getCode());
        if(mailService.verifyEmailCode(emailDto.getEmail(),emailDto.getCode())){
            Token token = tokenService.saveToken(emailDto.getEmail().split("@")[0]);
             response.setHeader("Authorization", "Bearer " + token.getAccessToken());
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.notFound().build();
    }
}
