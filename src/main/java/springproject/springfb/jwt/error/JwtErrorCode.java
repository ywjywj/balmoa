package springproject.springfb.jwt.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import springproject.springfb.common.ErrorCode;

@RequiredArgsConstructor
public enum JwtErrorCode implements ErrorCode {
        Token_Expired(HttpStatus.UNAUTHORIZED,"토큰이 만료되었습니다."),
        Token_Unsupported(HttpStatus.UNAUTHORIZED,"지원하지 않는 토큰입니다."),
        Token_Tampered(HttpStatus.UNAUTHORIZED,"유효하지 않은 서명입니다."),
        Token_Claims_Empty(HttpStatus.UNAUTHORIZED,"잘못된 토큰입니다."),
        Token_isNull(HttpStatus.UNAUTHORIZED,"토큰이 없습니다.");

        private final HttpStatus status;
        private final String message;
        // error code

        @Override
        public Integer getStatus() {
                return this.status.value();
        }

        @Override
        public String getMessage() {
                return this.message;
        }
}
