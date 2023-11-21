package springproject.springfb.common.controller;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import springproject.springfb.common.error.CommonErrorCode;
import springproject.springfb.common.response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundHandler(){
        ErrorResponse response = new ErrorResponse(CommonErrorCode.NOT_FOUND);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validHandler(MethodArgumentNotValidException exception){
        ErrorResponse response = new ErrorResponse(CommonErrorCode.INVALID_PATTERN);
        return ResponseEntity.status(response.getCode()).body(response);
    }
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorResponse> serverErrorHandler(){
//        ErrorResponse response = new ErrorResponse(CommonErrorCode.SERVER_ERROR);
//        return ResponseEntity.status(response.getCode()).body(response);
//    }
}