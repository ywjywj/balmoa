package springproject.springfb.common;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    public Integer getStatus();
    public String getMessage();
}
