package springproject.springfb.userTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import springproject.springfb.user.User;
import springproject.springfb.user.UserRepository;


@DataJpaTest
@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class userTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void save(){
        User user1 = User.of(21960009,"김민우","01012341234","SW");
        userRepository.save(user1);
    }
}
