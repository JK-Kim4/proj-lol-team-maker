package com.jw.teammaker.presentation.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * Dto: PlayerSaveDto
 *
 * 플레이어 저장 데이터 전송
 * */
@Getter
@Setter
public class PlayerSaveDto {

    private String name;

    private String nickName;

    private String Tier;

    private String mainPosition;

    private String subPosition;
}
