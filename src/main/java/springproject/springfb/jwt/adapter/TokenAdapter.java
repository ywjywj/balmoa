package springproject.springfb.jwt.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springproject.springfb.jwt.application.port.TokenPort;
import springproject.springfb.jwt.domain.Token;
import springproject.springfb.jwt.util.TokenUtil;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAdapter implements TokenPort {

    private final TokenRepository tokenRepository;
    private final TokenUtil tokenUtil;

    @Override
    public Token saveToken(final String id){
        Token token = tokenUtil.createToken(id);
        return tokenRepository.save(token);
    }


}
