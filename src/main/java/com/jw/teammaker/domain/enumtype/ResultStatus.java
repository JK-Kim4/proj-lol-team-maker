package com.jw.teammaker.domain.enumtype;

public enum ResultStatus {

    WIN("승리"), LOOSE("패배"), NO_COUNT("무효");

    private final String value;

    ResultStatus(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
