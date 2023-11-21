package springproject.springfb.common.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CommonErrorCode implements CommonError {
    NOT_FOUND(HttpStatus.NOT_FOUND,"요청하신 페이지를 찾을 수 없습니다."),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 오류 입니다.");


    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return this.httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
