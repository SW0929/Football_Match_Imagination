package server.kickoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.kickoff.domain.Member;
import server.kickoff.exception.DuplicationException;
import server.kickoff.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public Optional<Member> memberLogin(String loginId, String passwordId) {
        return memberRepository.findByLoginIdAndPassword(loginId, passwordId);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findByUserId(member.getUserId());
        if(!members.isEmpty()){
            throw new DuplicationException("이미 존재하는 아이디 입니다.");
        }
    }
}
