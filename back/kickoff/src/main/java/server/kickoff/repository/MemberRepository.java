package server.kickoff.repository;

import server.kickoff.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    void update(Long memberId, MemberUpdateDto memberParam);

    Optional<Member> findById(Long id);

    Optional<Member> findByLoginIdAndPassword(String id, String password);

}
