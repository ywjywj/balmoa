package springproject.springfb.common.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{
    INVALID_PATTERN(HttpStatus.BAD_REQUEST,"값 형식이 잘못되었습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND,"요청하신 페이지를 찾을 수 없습니다."),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 오류 입니다.");


    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public Integer getStatus() {
        return this.httpStatus.value();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
