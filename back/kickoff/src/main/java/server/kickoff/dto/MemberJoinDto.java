package server.kickoff.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberJoinDto {
    @NotBlank(message = "아이디에 공백이 있으면 안됩니다.")
    private String userId;
    @NotBlank(message = "비밀번호에 공백이 있으면 안됩니다.")
    private String password;

    private String userName;

    private String gender;

    private Integer age;

    private String phoneNumber;


    public MemberJoinDto() {
    }
}
