package springproject.springfb.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.springfb.member.model.Member;

public interface MemberRepository extends JpaRepository<Member,String> {
}


