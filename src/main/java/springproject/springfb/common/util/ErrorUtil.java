package springproject.springfb.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springproject.springfb.common.error.ErrorCode;
import springproject.springfb.common.response.ErrorResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ErrorUtil {
    private final ObjectMapper objectMapper;
    public void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse(errorCode);
        response.setStatus(errorResponse.getCode());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter()
                .write(objectMapper.writeValueAsString(errorResponse));
    }
}
