package springproject.springfb.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity(name="user")
public final class User {
    @NotNull(message = "학번을 기입해주세요")
    private final int studentId;

    @NotNull(message = "이름을 기입해주세요")
    private final String name;
    @NotNull(message = "전화번호를 기입해주세요")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
    private final String phone;
    @NotNull(message = "학과를 기입해주세요")
    private final String department;


    private User(int studentId, String name, String phone, String department) {
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.department = department;
    }

    public static User of(int studentId, String name, String phone, String department){
        return new User(studentId,name,phone,department);
    }


}
