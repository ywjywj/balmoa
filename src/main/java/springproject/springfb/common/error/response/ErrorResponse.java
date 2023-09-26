package springproject.springfb.common.error.response;

import lombok.Getter;
import springproject.springfb.common.error.code.ErrorCode;

@Getter
public class ErrorResponse {
    private final int code;
    private final String message;

    public ErrorResponse(ErrorCode errorCode){
        this.code = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
