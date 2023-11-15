package server.kickoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.kickoff.domain.Member;
import server.kickoff.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        // 중복 확인 로직?
        memberRepository.save(member);
        return member.getId();
    }

    public Optional<Member> memberLogin(String loginId, String passwordId) {
        return memberRepository.findByLoginIdAndPassword(loginId, passwordId);
    }
}
