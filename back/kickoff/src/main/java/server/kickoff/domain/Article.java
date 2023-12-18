package server.kickoff.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    private String title;

    @Column(name = "article_image")
    private String articleImage;

    @CreatedDate
    @Column(name = "creation_date")
    private Timestamp createDate;
}
