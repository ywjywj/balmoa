package springproject.springfb.user.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//com.Users.zkdl2.IdeaProjects.src.main.java.
//@EnableJpaRepositories(basePackages = "springproject.springfb.user.UserRepository")
//@EntityScan(basePackages = "springproject.springfb.user.User")
public class JpaConfig {
    @Bean
    @Qualifier(value = "endtityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.createEntityManager();
    }
}
