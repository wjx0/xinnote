package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "RESOURCE_INFO")
public class ResourceInfo extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_RESOURCE_INFO.nextval from dual")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "URL")
    private String url;

    @Column(name = "TYPE")
    private Long type;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CODE")
    private String code;

    @Column(name = "CONFIGURATION")
    private String configuration;

    @Column(name = "MODULE_NAME")
    private String moduleName;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

    @Column(name = "USING_FLAG")
    private String usingFlag;

    @Column(name = "ORDER_INDEX")
    private Long orderIndex;

    @Column(name = "INTERNET_FLAG")
    private String internetFlag;

    @Column(name = "ICON_NAME")
    private String iconName;

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
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return TYPE
     */
    public Long getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * @return STATUS
     */
    public Long getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * @return CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return CONFIGURATION
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration
     */
    public void setConfiguration(String configuration) {
        this.configuration = configuration == null ? null : configuration.trim();
    }

    /**
     * @return MODULE_NAME
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * @return PARENT_ID
     */
    public BigDecimal getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
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

    /**
     * @return ORDER_INDEX
     */
    public Long getOrderIndex() {
        return orderIndex;
    }

    /**
     * @param orderIndex
     */
    public void setOrderIndex(Long orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * @return INTERNET_FLAG
     */
    public String getInternetFlag() {
        return internetFlag;
    }

    /**
     * @param internetFlag
     */
    public void setInternetFlag(String internetFlag) {
        this.internetFlag = internetFlag == null ? null : internetFlag.trim();
    }

    /**
     * @return ICON_NAME
     */
    public String getIconName() {
        return iconName;
    }

    /**
     * @param iconName
     */
    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
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
        sb.append(", url=").append(url);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", code=").append(code);
        sb.append(", configuration=").append(configuration);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", parentId=").append(parentId);
        sb.append(", usingFlag=").append(usingFlag);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", internetFlag=").append(internetFlag);
        sb.append(", iconName=").append(iconName);
        sb.append("]");
        return sb.toString();
    }
}