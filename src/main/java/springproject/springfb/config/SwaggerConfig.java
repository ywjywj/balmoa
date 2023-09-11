package springproject.springfb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi userAPI(){
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/balmoa/users/**")
                .build();
    }
    @Bean
    public OpenAPI balmoaAPI(){
        return new OpenAPI()
                .info(new Info().title("Balmoa API")
                        .description("Balmoa API 명세서"));
    }

}
