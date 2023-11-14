package server.kickoff.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Member {

    private Long id;

    private String userId;

    private String password;

    private String userName;

    private String gender;

    private Integer age;

    private String phoneNumber;

    private String position;

    private Timestamp createDate;

    public Member() {
    }

    public Member(String userId, String password, String userName, String gender, Integer age, String phoneNumber, String position, Timestamp createDate) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.createDate = createDate;
    }
}
