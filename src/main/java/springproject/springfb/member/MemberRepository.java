package springproject.springfb.member;

import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberRepository extends JpaRepository<Member,Integer> {
}


