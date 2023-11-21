package springproject.springfb.email.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class AuthCodeRequest {

    @NotEmpty(message = "학번은 필수 입니다.")
    @Pattern(regexp = "^\\d{3}[1-6]\\d{4}$",message = "값 형식이 잘못되었습니다.")
    private String id;
}
