package springproject.springfb.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import springproject.springfb.common.error.CommonError;
import springproject.springfb.common.error.CommonErrorCode;
import springproject.springfb.common.error.CommonException;
import springproject.springfb.common.error.ValidErrorEntity;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public CommonError customExceptionHandler(CommonException commonException){
        return commonException.getCommonError();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidErrorEntity validRequestParam(MethodArgumentNotValidException exception){
        List<String> messages = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return ValidErrorEntity.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(messages)
                .build();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonError notFound(NoHandlerFoundException exception){
        return CommonErrorCode.NOT_FOUND;
    }

}