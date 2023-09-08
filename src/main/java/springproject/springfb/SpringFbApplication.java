package springproject.springfb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"springproject.springfb.user"})
=======
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "springproject.springfb")
@EntityScan(basePackages = "springproject.springfb.User")
//@ComponentScan(basePackages = {"springproject.springfb"})
>>>>>>> wonjun
public class SpringFbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFbApplication.class, args);
	}

}
