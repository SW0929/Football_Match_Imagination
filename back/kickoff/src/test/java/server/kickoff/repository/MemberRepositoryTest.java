package server.kickoff.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import server.kickoff.domain.Member;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    void save() {
        //given
        Member member = new Member();
        member.settingMemberInfo("memberId",
                "1234",
                "memberA",
                "F",
                20,
                "01096485709",
                "GK");

        //when
        Member savedMember = memberRepository.save(member);

        //when
        assertThat(savedMember).isEqualTo(memberRepository.findById(savedMember.getId()).get());
        
    }

    @Test
    @Transactional
    void findByLoginIdAndPassword() {
        //given
        Member member = new Member();
        member.settingMemberInfo("memberId",
                "1234",
                "memberA",
                "F",
                20,
                "01096485709",
                "GK");
        Member saveMember = memberRepository.save(member);

        //when
        Optional<Member> optionalMember = memberRepository.findByLoginIdAndPassword(saveMember.getUserId(), saveMember.getPassword());
        Member loginMember = optionalMember.orElseThrow();

        //then
        assertThat(loginMember).isEqualTo(saveMember);
    }

    @Test
    void update() {
    }

}