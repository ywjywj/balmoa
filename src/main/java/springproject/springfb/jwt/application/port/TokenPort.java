package springproject.springfb.jwt.application.port;


import springproject.springfb.jwt.domain.Token;

public interface TokenPort {
    Token saveToken(final String id);

}
