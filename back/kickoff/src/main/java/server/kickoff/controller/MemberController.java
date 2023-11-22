package server.kickoff.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.kickoff.domain.Member;
import server.kickoff.repository.MemberJoinDto;
import server.kickoff.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kick-off")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/user/join")
    public CreateMemberResponse joinMember(@Valid @RequestBody MemberJoinDto joinDto) {

        Member member = new Member();
        member.settingMemberInfo( joinDto.getUserId(),
                joinDto.getPassword(),
                joinDto.getUserName(),
                joinDto.getGender(),
                joinDto.getAge(),
                joinDto.getPhoneNumber(),
                joinDto.getPosition());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }


    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;

    }
}
