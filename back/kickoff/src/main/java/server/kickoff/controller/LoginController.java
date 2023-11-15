package server.kickoff.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.kickoff.domain.Member;
import server.kickoff.service.MemberService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kick-off")
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/user/login")
    public Object memberLogin(@RequestBody @Valid LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 에러 응답 JSON 반환 로직
        }
        Optional<Member> optionalMember = memberService.memberLogin(form.getLoginId(), form.getPassword());

        if (optionalMember.isPresent()) {
            // 로그인 성공 로직
            return
        }

        //로그인 실패 로직
    }
}
