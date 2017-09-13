package com.xin.note.security.enums;

public enum UseStatusEnum {
    ENABLE("启用","1"),DISABLE("禁用","0");
    private String description;
    private String value;
    UseStatusEnum(String description,String value){
        this.description=description;
        this.value=value;
    }

    public String getDescription() {
        return description;
    }


    public String getValue() {
        return value;
    }
}
