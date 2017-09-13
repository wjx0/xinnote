package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ROLE_INFO")
public class RoleInfo extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_ROLE_INFO.nextval from dual")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USING_FLAG")
    private String usingFlag;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return USING_FLAG
     */
    public String getUsingFlag() {
        return usingFlag;
    }

    /**
     * @param usingFlag
     */
    public void setUsingFlag(String usingFlag) {
        this.usingFlag = usingFlag == null ? null : usingFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", usingFlag=").append(usingFlag);
        sb.append("]");
        return sb.toString();
    }
}