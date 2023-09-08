package springproject.springfb.user;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotNull(message = "학번을 기입해주세요")
    private int studentId;

    @NotNull(message = "이름을 기입해주세요")
    private String name;
    @NotNull(message = "전화번호를 기입해주세요")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
    private String phone;
    @NotNull(message = "학과를 기입해주세요")
    private String department;


}
