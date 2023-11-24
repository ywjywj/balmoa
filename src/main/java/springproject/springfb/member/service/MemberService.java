package springproject.springfb.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springproject.springfb.member.repository.MemberRepository;
import springproject.springfb.member.model.Member;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

   private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }
}
