package server.kickoff.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    private String password;

    @Column(name = "user_name")
    private String userName;

    private String gender;

    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CreatedDate
    private Timestamp createDate;

    public Member() {

    }

    public void settingMemberInfo(String userId, String password, String userName, String gender, Integer age, String phoneNumber) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
