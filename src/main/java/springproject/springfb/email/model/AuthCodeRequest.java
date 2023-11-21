package springproject.springfb.email.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class AuthCodeRequest {

    @NotEmpty(message = "학번은 필수입니다.")
    @Pattern(regexp = "^\\d{3}[1-6]\\d{4}$",message = "학번 형식이 유효하지 않습니다. 8자리가 아니거나, 학과코드가 유효하지 않습니다.")
    private String id;
}
