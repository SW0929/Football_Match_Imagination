package server.kickoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.kickoff.domain.Member;

import java.util.List;
import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByUserId(String userId);

    Optional<Member> findByUserIdAndPassword(String userId, String password);
}
