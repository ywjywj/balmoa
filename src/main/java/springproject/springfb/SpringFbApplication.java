package springproject.springfb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "springproject.springfb")
@EntityScan(basePackages = {"springproject.springfb.member","springproject.springfb.jwt.domain"})
@EnableWebMvc
public class SpringFbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringFbApplication.class, args);
	}

}
