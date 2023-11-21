package springproject.springfb.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springproject.springfb.common.error.CommonError;
import springproject.springfb.common.error.CommonErrorCode;
import springproject.springfb.common.error.CommonException;
import springproject.springfb.common.model.CommonApiResponse;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonApiResponse<Object>> customExceptionHandler(CommonException commonException){
        CommonError errorCode = commonException.getCommonError();
        CommonApiResponse<Object> response = CommonApiResponse.builder()
                .code(errorCode.getStatus().value())
                .message(errorCode.getMessage())
                .build();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonApiResponse<Object>> validRequestParam(MethodArgumentNotValidException exception){
        CommonApiResponse<Object> response = CommonApiResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(exception.getBindingResult().getFieldError().getDefaultMessage())
                .build();
        return ResponseEntity.status(response.getCode()).body(response);
    }

}