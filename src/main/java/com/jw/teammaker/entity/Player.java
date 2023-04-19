package com.jw.teammaker.entity;

import com.jw.teammaker.entity.enumtype.Position;
import com.jw.teammaker.entity.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import lombok.AllArgsConstructor;

import javax.persistence.*;


/**
 * Entity: Player
 *
 * 게임 플레이어 정보 관리
 * */
@Entity
@AllArgsConstructor
public class Player {


    public Player(){};

    public Player(PlayerSaveDto dto){
        this.name = dto.getName();
        this.nickname = dto.getNickName();
        this.tier = Tier.valueOf(dto.getTier());
        this.mainPosition = Position.valueOf(dto.getMainPosition());
        this.subPosition = Position.valueOf(dto.getSubPosition());
    }

    @Id @GeneratedValue
    @Column(name = "PLAYER_ID")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 120)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Tier tier;

    @Enumerated(EnumType.STRING)
    private Position mainPosition;

    @Enumerated(EnumType.STRING)
    private Position subPosition;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Tier getTier() {
        return tier;
    }

    public Position getMainPosition() {
        return mainPosition;
    }

    public Position getSubPosition() {
        return subPosition;
    }
}

