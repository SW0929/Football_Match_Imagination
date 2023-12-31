package server.kickoff.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.kickoff.domain.Member;
import server.kickoff.dto.MemberJoinDto;
import server.kickoff.dto.ResponseDto;
import server.kickoff.service.MemberService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kick-off")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/user/join")
    public ResponseDto joinMember(@Valid @RequestBody MemberJoinDto joinDto) {
        log.info("joinMember");
        Member member = new Member();
        member.settingMemberInfo( joinDto.getUserId(),
                joinDto.getPassword(),
                joinDto.getUserName(),
                joinDto.getGender(),
                joinDto.getAge(),
                joinDto.getPhoneNumber());

        Long id = memberService.join(member);
        return new ResponseDto(id + " 유저가 생성",null);
    }


}
