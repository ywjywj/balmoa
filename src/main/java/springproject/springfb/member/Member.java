package springproject.springfb.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "사용자 DTO")
@Data
@Entity(name="member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    //mysql 버전 문제로 다시 pull 할 예정.(5.7버전)
    //그래서 db 테이블에 관해서 고민. pk를 member_id로 할지 student_id로 할지(즉 member_id를 지울까 고민)
    //crud 측면에서 필요할거 같다고 생각하면 추가. 논의 필요. 그 후에 swagger 사용해서 확인해보는걸로.
    @Schema(description = "학번", example = "21860004")
    @Id
    @NotNull(message = "학번을 기입해주세요")
    private String studentId;

    @Schema(description = "이름", example = "권재웅")
    @NotNull(message = "이름을 기입해주세요")
    private String name;

    @Schema(description = "전화번호", example = "010-1234-5678")
    @NotNull(message = "전화번호를 기입해주세요")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
    private String phone;

    @Schema(description = "학과", example = "스마트소프트웨어학과")
    @NotNull(message = "학과를 기입해주세요")
    private String major;

    @Schema(description = "예약 시간")
    private int reservationTime;

}
