package springproject.springfb.user;

<<<<<<< HEAD
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
=======
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;
//    @NotNull(message = "학번을 기입해주세요")
//    @Column(name="student_id")
    private int studentId;

//    @NotNull(message = "이름을 기입해주세요")
//    @Column(name="name")
    private String name;
//    @NotNull(message = "전화번호를 기입해주세요")
//    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
//    @Column(name="phone")
    private String phone;
//    @NotNull(message = "학과를 기입해주세요")
//    @Column(name="department")
    private  String department;
>>>>>>> wonjun


//    private User(int studentId, String name, String phone, String department) {
//        this.studentId = studentId;
//        this.name = name;
//        this.phone = phone;
//        this.department = department;
//    }

<<<<<<< HEAD
=======
    //final로 클래서 지정시.
>>>>>>> wonjun
//    public static User of(int studentId, String name, String phone, String department){
//        return new User(studentId,name,phone,department);
//    }


}
