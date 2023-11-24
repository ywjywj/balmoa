package springproject.springfb.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springproject.springfb.common.model.CommonApiResponse;
import springproject.springfb.email.model.AuthCodeRequest;
import springproject.springfb.member.model.Member;
import springproject.springfb.member.service.MemberService;

import java.util.List;

@Slf4j
@Tag(name="members", description = "예약 기능 API")
@RestController
@RequestMapping(value="/balmoa/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(description = "현재 예약 현황을 조회 API",security = @SecurityRequirement(name = "bearer-key"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "성공",
               content = @Content(array = @ArraySchema(schema = @Schema(implementation = Member.class)))),
            @ApiResponse(responseCode = "401",description = "인증 실패",
                content = @Content(schema = @Schema(implementation = CommonApiResponse.class))),
            @ApiResponse(responseCode = "500",description = "내부 서버 오류")
    })

    @GetMapping("")
    public ResponseEntity<List<Member>> GetAllMembers(){
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @Operation(description = "예약 신청 API",security = @SecurityRequirement(name = "bearer-key"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "성공"),
            @ApiResponse(responseCode = "401",description = "인증 실패"),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류")
    })
    @PostMapping("/save")
    public ResponseEntity<Member> save(@RequestBody @Valid Member member){
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

    @Operation(description = "예약 취소 API", security = @SecurityRequirement(name = "bearer-key"))
    @PostMapping("cancel")
    public ResponseEntity<?> cancel(@RequestBody @Valid AuthCodeRequest authCodeRequest){
        boolean flag = memberService.cancel(authCodeRequest);

        if(flag){
            CommonApiResponse<Object> response = CommonApiResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("삭제 성공")
                    .build();
            return ResponseEntity.status(response.getCode()).body(response);
        }
        return null;
    }
}
