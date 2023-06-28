package springproject.springfb.userTest;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.Validator;
import springproject.springfb.user.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ValidationUserTest {
    private Validator validatorInjected;
    @Test
    void user_null_test(){
        User user = User.of(21960029,"유원준","010-9512-2347","스마트소프트웨어");

//        Set<ConstraintViolation<User>> validate = validatorInjected.validate();
//
//        // then
//        Iterator<ConstraintViolation<User>> iterator = validate.iterator();
//        List<String> messages = new ArrayList<>();
//        while (iterator.hasNext()) {
//            ConstraintViolation<User> next = iterator.next();
//            messages.add(next.getMessage());
//            System.out.println("message = " + next.getMessage());
//        }
    }
}
