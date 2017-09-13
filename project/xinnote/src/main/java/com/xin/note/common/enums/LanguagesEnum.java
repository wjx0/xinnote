package com.xin.note.common.enums;

/**
 * @author xin
 */
public enum LanguagesEnum {
    ENGLISH("英文","en_US"),CHINESE("中文","zh_CN"),JAPANESE("日文","ja_JP");
    private String description;
    private String value;
    LanguagesEnum(String description, String value){
        this.description=description;
        this.value=value;
    }

    public String getDescription() {
        return description;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return  this.value;
    }

}
