package springproject.springfb.jwt.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springproject.springfb.jwt.application.port.TokenPort;
import springproject.springfb.jwt.domain.Token;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAdapter implements TokenPort {

    private final TokenRepository tokenRepository;

    @Override
    public Token saveToken(final Token token){
        return tokenRepository.save(token);
    }

}
