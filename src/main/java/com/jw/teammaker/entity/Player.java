package com.jw.teammaker.entity;

import com.jw.teammaker.entity.enumtype.Position;
import com.jw.teammaker.entity.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


/**
 * Entity: Player
 *
 * 게임 플레이어 정보 관리
 * */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {


    @Builder
    public Player(PlayerSaveDto saveDto){
        this.name = saveDto.getName();
        this.nickname = saveDto.getNickName();
        this.mainPosition = Position.valueOf(saveDto.getMainPosition());
        this.mainTier = Tier.valueOf(saveDto.getMainTier());
        this.subPosition = Position.valueOf(saveDto.getSubPosition());
        this.subTier = Tier.valueOf(saveDto.getSubTier());
        this.badPlayerRating = 0;
    }

    public Player update(PlayerUpdateDto updateDto) {
        this.nickname = updateDto.getNickName();
        this.mainPosition = Position.valueOf(updateDto.getMainPosition());
        this.mainTier = Tier.valueOf(updateDto.getMainTier());
        this.subPosition = Position.valueOf(updateDto.getSubPosition());
        this.subTier = Tier.valueOf(updateDto.getSubTier());
        return this;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 120)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Position mainPosition;

    @Enumerated(EnumType.STRING)
    private Tier mainTier;

    @Enumerated(EnumType.STRING)
    private Position subPosition;

    @Enumerated(EnumType.STRING)
    private Tier subTier;

    @Column
    @ColumnDefault("0")
    private int badPlayerRating;

}

