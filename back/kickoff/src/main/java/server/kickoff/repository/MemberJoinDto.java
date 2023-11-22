package server.kickoff.repository;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberJoinDto {
    @NotBlank(message = "아이디에 공백이 있으면 안됩니다.")
    private String userId;

    private String password;

    private String userName;

    private String gender;

    private Integer age;

    private String phoneNumber;

    private String position;

    public MemberJoinDto() {
    }
}
