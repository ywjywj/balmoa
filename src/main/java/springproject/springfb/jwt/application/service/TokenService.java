package springproject.springfb.jwt.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springproject.springfb.jwt.application.port.TokenPort;
import springproject.springfb.jwt.domain.Token;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenPort tokenPort;
    public Token saveToken(final Token token){
        return tokenPort.saveToken(token);
    }

}
