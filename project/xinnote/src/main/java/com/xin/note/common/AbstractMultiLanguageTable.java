package com.xin.note.common;

import javax.persistence.Column;

/**
 * @author xin
 * 语言表标准结构，其中keyId,languageCode,name都是标准字段，建表必须符合规范
 */
public abstract class AbstractMultiLanguageTable extends EntityBean<Long>{
    //主表的id
    @Column(name = "KEY_ID")
    private Long keyId;
    //语言字段
    @Column(name = "LANGUAGE_CODE")
    private String languageCode;
    //多语言的值
    @Column(name = "NAME")
    private String name;

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
