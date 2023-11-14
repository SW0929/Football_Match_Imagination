package server.kickoff.repository;

import lombok.Data;

@Data
public class MemberJoinDto {

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
