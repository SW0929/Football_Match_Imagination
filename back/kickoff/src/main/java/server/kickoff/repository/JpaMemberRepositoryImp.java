package server.kickoff.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import server.kickoff.domain.Member;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMemberRepositoryImp implements MemberRepository{

    private final JpaMemberRepository repository;

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public void update(Long memberId, MemberUpdateDto memberParam) {

    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Member> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Optional<Member> findByLoginIdAndPassword(String loginId, String password) {
        return repository.findByUserIdAndPassword(loginId,password);
    }
}
