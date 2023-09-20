package springproject.springfb.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("token")
public class Token implements Serializable {

    @Id
    private String tokenId;
    private String accessToken;
    // private String refreshToken;

}
