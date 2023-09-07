package springproject.springfb.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


   private final UserRepository userRepository;
//    @Autowired
////    @Qualifier(value = "entityManager")
////    EntityManager manager;
//    private final UserRepositoryImpl userRepository;
//
//    @Autowired
//    public UserService(UserRepositoryImpl userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> findAll() {
//        List<User> users = new ArrayList<>();
//        userRepository.findAll().forEach(e-> users.add(e));
        return userRepository.findAll();
    }
    public User save(User user){
        userRepository.save(user);
        return user;
    }
}
