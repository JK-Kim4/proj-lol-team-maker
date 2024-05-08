package com.jw.teammaker.domain.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class HelloMessage {

    public HelloMessage(String name){
        this.name = name;
    }

    private String name;
}
