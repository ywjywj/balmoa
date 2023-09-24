package springproject.springfb.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import springproject.springfb.jwt.util.TokenUtil;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
@Order(value = Integer.MIN_VALUE + 1)
public class JwtFilter extends OncePerRequestFilter {

    private final TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("[JwtFilter - Request URL] : {}", request.getRequestURI());
        List<String> list = List.of(
                "/swagger-ui/",
                "/v3/api-docs/",
                "/balmoa/mail"
        );
        boolean flag = list.stream().anyMatch(url -> request.getRequestURI().startsWith(url));
        // 현재 URL 이 LIST 안에 포함되있는걸로 시작되나?
        if(flag) {
            filterChain.doFilter(request,response);
            return;
        }

        String header = request.getHeader("Authorization");
        log.info("[JwtFilter - header] : {}",header);
        if(header != null && !header.equalsIgnoreCase("")){
            if(header.startsWith("Bearer")){
                String access_token = header.split(" ")[1];
                if(tokenUtil.isValidToken(access_token)){
                    filterChain.doFilter(request,response);
                }
            }
        } else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
}