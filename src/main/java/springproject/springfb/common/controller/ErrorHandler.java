package springproject.springfb.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import springproject.springfb.common.error.CommonErrorCode;
import springproject.springfb.common.response.ErrorResponse;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundHandler(){
        ErrorResponse response = new ErrorResponse(CommonErrorCode.Not_Found);
        return ResponseEntity.status(response.getCode()).body(response);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> serverErrorHandler(){
        ErrorResponse response = new ErrorResponse(CommonErrorCode.Server_Error);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}