package com.jw.teammakter;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.Tier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> positionPoint = Position.stream()
                .map(p -> p.getPoint())
                .collect(Collectors.toList());
        List<Integer> tierPoint = Tier.stream()
                .map(t -> t.getPoint())
                .collect(Collectors.toList());

        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        for(int i = 0; i < positionPoint.size(); i++){
            for(int j = 0; j < tierPoint.size(); j++){
                resultArray.add((positionPoint.get(i) + tierPoint.get(j)));
            }

        }
        Collections.sort(resultArray);

        resultArray.stream().forEach(System.out::println);

    }
}
