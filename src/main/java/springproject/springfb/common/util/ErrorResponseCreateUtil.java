package springproject.springfb.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springproject.springfb.common.error.CommonError;
import springproject.springfb.common.model.CommonApiResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ErrorResponseCreateUtil {
    private final ObjectMapper objectMapper;
    public void setResponse(HttpServletResponse response, CommonError commonError) throws IOException {
        CommonApiResponse<Object> apiResponse = CommonApiResponse.builder()
                .message(commonError.getMessage())
                .build();

        response.setStatus(commonError.getStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter()
                .write(objectMapper.writeValueAsString(apiResponse));
    }
}
