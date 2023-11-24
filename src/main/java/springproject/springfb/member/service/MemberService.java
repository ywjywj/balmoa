package springproject.springfb.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.springfb.email.model.AuthCodeRequest;
import springproject.springfb.member.repository.MemberRepository;
import springproject.springfb.member.model.Member;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

   private final MemberRepository memberRepository;

   @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    @Transactional
    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }
    @Transactional
    public boolean cancel(AuthCodeRequest authCodeRequest){
        memberRepository.deleteById(authCodeRequest.getId());
        return memberRepository.findById(authCodeRequest.getId()).isEmpty();
    }
}
