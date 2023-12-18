package server.kickoff.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "match_time")
    private Timestamp matchTime;

    @Column(name = "match_location")
    private String matchLocation;
}
