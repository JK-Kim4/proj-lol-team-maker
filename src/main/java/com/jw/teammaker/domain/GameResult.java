package com.jw.teammaker.domain;

import com.jw.teammaker.domain.enumtype.ResultStatus;

import javax.persistence.*;

@Entity
public class GameResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ResultStatus resultStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
}
