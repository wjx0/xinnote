package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "OPERATION_LOG")
public class OperationLog extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_OPERATION_LOG.nextval from dual")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "METHOD_NAME")
    private String methodName;

    @Column(name = "MESSAGE")
    private String message;

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
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return BUSINESS_NAME
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    /**
     * @return CLASS_NAME
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * @return METHOD_NAME
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * @return MESSAGE
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", userName=").append(userName);
        sb.append(", businessName=").append(businessName);
        sb.append(", className=").append(className);
        sb.append(", methodName=").append(methodName);
        sb.append(", message=").append(message);
        sb.append("]");
        return sb.toString();
    }
}