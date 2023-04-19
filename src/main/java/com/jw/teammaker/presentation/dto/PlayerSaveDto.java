package com.jw.teammaker.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Dto: PlayerSaveDto
 *
 * 플레이어 저장 데이터 전송
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSaveDto {

    private String name;

    private String nickName;

    private String Tier;

    private String mainPosition;

    private String subPosition;

    @Override
    public String toString() {
        return "PlayerSaveDto{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", Tier='" + Tier + '\'' +
                ", mainPosition='" + mainPosition + '\'' +
                ", subPosition='" + subPosition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerSaveDto that = (PlayerSaveDto) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getNickName(), that.getNickName()) && Objects.equals(getTier(), that.getTier()) && Objects.equals(getMainPosition(), that.getMainPosition()) && Objects.equals(getSubPosition(), that.getSubPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNickName(), getTier(), getMainPosition(), getSubPosition());
    }
}
