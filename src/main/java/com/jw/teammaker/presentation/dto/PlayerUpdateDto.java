package com.jw.teammaker.presentation.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto: PlayerUpdateDto
 *
 * 플레이어 수정 데이터 전송
 * */
@Getter
@Setter
@NoArgsConstructor
public class PlayerUpdateDto {

    private Long playerId;

    private String nickName;

    private String mainPosition;

    private String mainTier;

    private String subPosition;

    private String subTier;
}
