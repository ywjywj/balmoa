package springproject.springfb.email.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "이메일 DTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailAuthRequest {

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Email(message = "이메일 형식이 맞지 않습니다.")
    @Schema(description = "학교 이메일", example = "12345678@st.yc.ac.kr")
    private String email;

    @NotEmpty(message = "인증코드는 필수 입니다.")
    @Schema(description = "학교 이메일로 전송된 코드")
    private String code;
}
