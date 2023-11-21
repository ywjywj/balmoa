package springproject.springfb.common.error;

import org.springframework.http.HttpStatus;

public interface CommonError {

    HttpStatus getStatus();
    String getMessage();
}
