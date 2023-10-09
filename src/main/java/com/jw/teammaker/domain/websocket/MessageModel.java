package com.jw.teammaker.domain.websocket;

public class MessageModel {
    private String name;

    public MessageModel() {
    }

    public MessageModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
