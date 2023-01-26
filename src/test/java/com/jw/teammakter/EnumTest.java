package com.jw.teammakter;

import com.jw.teammakter.domain.Position;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void Enum_test(){
        String position1 = "JUNGLE";

        Position position = Position.valueOf(position1);

        System.out.println(position.getPosition());
        System.out.println(position.getPoint());


    }

    @Test
    void Enum_Iterating_test(){
        Position.stream().forEach(System.out::println);
    }
}
