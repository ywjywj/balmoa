package springproject.springfb.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import springproject.springfb.jwt.util.TokenUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final TokenUtil tokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("[Request Url] : {}", request.getRequestURI());
        List<String> list = Arrays.asList(
                "/balmoa/test"
        );

        if(list.contains(request.getRequestURI())) {
            String header = request.getHeader("Authorization");
            log.info("[JwtFilter] : {}",header);
            if(header != null && !header.equalsIgnoreCase("")){
                if(header.startsWith("Bearer")){
                    String access_token = header.split(" ")[1];

                    if(tokenUtil.isValidToken(access_token)){
                        filterChain.doFilter(request,response);
                    }
                }
            }
        }

        filterChain.doFilter(request,response);
    }
}
