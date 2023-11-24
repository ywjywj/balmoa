package springproject.springfb.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springproject.springfb.common.error.CommonError;
import springproject.springfb.common.error.ValidErrorEntity;
import springproject.springfb.common.model.CommonApiResponse;

@Slf4j
@RestControllerAdvice(basePackages = {"springproject.springfb.email",
        "springproject.springfb.member","springproject.springfb.common.controller"})
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("fuck : {}",body);
        if(body instanceof ValidErrorEntity){
            response.setStatusCode(((ValidErrorEntity) body).getStatus());
            return CommonApiResponse.builder()
                    .message(((ValidErrorEntity) body).getMessage())
                    .build();
        }

        if(body instanceof CommonError){
            response.setStatusCode(((CommonError)body).getStatus());
            return CommonApiResponse.builder()
                    .message(((CommonError) body).getMessage())
                    .build();
        }

        return CommonApiResponse.builder()
                .data(body)
                .build();
    }
}
