package server.kickoff.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.kickoff.domain.Member;
import server.kickoff.dto.LoginFormDto;
import server.kickoff.dto.ResponseDto;
import server.kickoff.service.MemberService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kick-off")
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/user/login")
    public ResponseDto memberLogin(@RequestBody @Valid LoginFormDto form) {
        log.info("login ok");
        Optional<Member> optionalMember = memberService.memberLogin(form.getLoginId(), form.getPassword());
        if (optionalMember.isPresent()) {
            return new ResponseDto("Login successful",form.getLoginId());
        }

        //로그인 실패 로직
        return new ResponseDto("Login fail",form.getLoginId());
    }


    @Data
    @AllArgsConstructor
    static class LoginMemberResponse {
        private boolean status;
        private String message;
    }
}
