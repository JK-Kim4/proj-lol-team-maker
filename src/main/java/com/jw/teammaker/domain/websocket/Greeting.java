package com.jw.teammaker.domain.websocket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class Greeting {

    public Greeting(String content) {
        this.content = content;
    }

    private String content;

}
