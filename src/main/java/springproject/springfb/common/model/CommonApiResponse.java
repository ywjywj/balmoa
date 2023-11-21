package springproject.springfb.common.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class CommonApiResponse<T> {
    private final int code;
    private final String message;
    private final T t;
}
