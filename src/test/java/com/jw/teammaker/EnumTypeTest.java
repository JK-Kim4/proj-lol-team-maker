package com.jw.teammaker;

import com.jw.teammaker.domain.enumtype.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class EnumTypeTest {


    @Test
    public void get_position_name(){
        Position position = Position.TOP;
        System.out.println("get point result = " +position.getPoint());
        System.out.println("name result = " +position.name());
    }
}
