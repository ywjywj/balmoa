package springproject.springfb.jwt.adapter;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springproject.springfb.jwt.domain.Token;


@Repository
public interface TokenRepository extends CrudRepository<Token,String> {

}
