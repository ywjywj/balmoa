package springproject.springfb.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name= "users", description = "예약 기능 API")
@RestController
@RequestMapping(value="/balmoa/users")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(description = "현재 예약 현황을 조회 API",security = @SecurityRequirement(name = "bearer-key"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "success",
               content = @Content(array = @ArraySchema(schema = @Schema(implementation = Member.class))))
    })
    @GetMapping("")
    public ResponseEntity<List<Member>> GetAllMembers(){
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @Operation(description = "예약 신청 API",security = @SecurityRequirement(name = "bearer-key"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "success",
                    content = @Content(schema = @Schema(implementation = Member.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/save")
    public ResponseEntity<Member> save(@RequestBody Member member){
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }
}
