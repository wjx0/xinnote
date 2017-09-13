package com.xin.note.common.enums;

/**
 * @author xin
 */
public enum DeletedFlagEnum {
    DELETED("已删除","1"),NOTDELETED("未删除","0");
    private String description;
    private String value;
    DeletedFlagEnum(String description,String value){
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
