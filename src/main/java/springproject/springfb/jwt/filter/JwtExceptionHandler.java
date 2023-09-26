package springproject.springfb.jwt.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import springproject.springfb.common.error.util.ErrorUtil;
import springproject.springfb.jwt.error.JwtErrorCode;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
@Order(value = Integer.MIN_VALUE)
public class JwtExceptionHandler extends OncePerRequestFilter {
    private final ErrorUtil errorUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[JwtExceptionHandler - Request URL] : {}",request.getRequestURI());
        try {
            doFilter(request,response,filterChain);
        } catch (ExpiredJwtException exception){
            errorUtil.setResponse(response, JwtErrorCode.Token_Expired);
        } catch (SignatureException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Tampered);
        } catch (UnsupportedJwtException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Unsupported);
        } catch(MalformedJwtException | IllegalArgumentException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Claims_Empty);
        } catch (ResponseStatusException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_isNull);
        }
    }
}
