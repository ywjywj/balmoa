package springproject.springfb.common.error;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{
    private final CommonError commonError;

    public CommonException(CommonError commonError){
        this.commonError = commonError;
    }
}
