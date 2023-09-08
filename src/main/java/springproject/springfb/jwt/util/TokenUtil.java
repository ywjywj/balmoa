package springproject.springfb.jwt.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import springproject.springfb.jwt.domain.Token;
import springproject.springfb.user.User;


import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

@Slf4j
@Component
public class TokenUtil {


    private final String secretKey;

    public TokenUtil(@Value("${spring.jwt.secret}") String secretKey) {
        log.debug("validation : {}",secretKey);
        this.secretKey = secretKey;
    }



    public Token createToken(User user){

        String access_token = Jwts.builder()
                .setHeader(createHeader())
                .setClaims(createClaims())
                .setSubject(String.valueOf(user.getStudentId()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60)) // 토큰 만료 시간
                .signWith(createSignature(),SignatureAlgorithm.HS256)
                .compact();

        String refresh_token = Jwts.builder()
                .setSubject(String.valueOf(user.getStudentId()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*5))
                .signWith(createSignature(),SignatureAlgorithm.HS256)
                .compact();

        return new Token(access_token,refresh_token);

    }

    public Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(createSignature())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaims(token);
            return true;
        } catch (ExpiredJwtException exception) {
            log.error("Token Expired");
            return false;
        } catch (JwtException exception) {
            log.error("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            log.error("Token is null");
            return false;
        }
    }



    private Map<String,Object> createHeader(){
        Map<String,Object> headers = new HashMap<>();

        headers.put("typ", "JWT");
        headers.put("alg", "HS256"); // 서명 생성에 사용될 알고리즘

        return headers;
    }

    // Claim -> 사용자 혹은 토큰에 대한 property 를 key-value 형태로 저장함.
    private Map<String,Object> createClaims(){
        Map<String,Object> claims = new HashMap<>();

        claims.put("iat",System.currentTimeMillis()); // 토큰 발급 시간
        claims.put("token_type","Bearer");
        return claims;
    }

    private Key createSignature() {
        byte[] apiKeySecretBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

 }
