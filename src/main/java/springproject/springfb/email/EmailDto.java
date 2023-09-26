package springproject.springfb.email;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "이메일 DTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    @Email
    @Schema(description = "학교 이메일", example = "12345678@st.yc.ac.kr")
    private String email;

    @Schema(description = "학교 이메일로 전송된 코드")
    private String code;
}
