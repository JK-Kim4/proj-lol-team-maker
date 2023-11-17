package com.jw.teammaker.presentation.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * Dto: PlayerSaveDto
 *
 * 플레이어 저장 데이터 전송
 * */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlayerSaveDto {

    private String name;

    private String nickName;

    private String mainPosition;
    private String mainTier;

    private String subPosition;
    private String subTier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerSaveDto that = (PlayerSaveDto) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getNickName(), that.getNickName()) && Objects.equals(getMainPosition(), that.getMainPosition()) && Objects.equals(getMainTier(), that.getMainTier()) && Objects.equals(getSubPosition(), that.getSubPosition()) && Objects.equals(getSubTier(), that.getSubTier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNickName(), getMainPosition(), getMainTier(), getSubPosition(), getSubTier());
    }


}
