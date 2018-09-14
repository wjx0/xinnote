package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "OPERATION_LOG")
public class OperationLog extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_OPERATION_LOG.nextval from dual")
    private Long id;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date gmtModified;

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;

    @Column(name = "DELETED_FLAG")
    private String deletedFlag;

    @Column(name = "OPERATION_NAME")
    private String operationName;

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
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return CREATE_BY
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return LAST_MODIFIED_BY
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }

    /**
     * @return GMT_CREATE
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return GMT_MODIFIED
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return MODIFICATION_NUM
     */
    public Integer getModificationNum() {
        return modificationNum;
    }

    /**
     * @param modificationNum
     */
    public void setModificationNum(Integer modificationNum) {
        this.modificationNum = modificationNum;
    }

    /**
     * @return DELETED_FLAG
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * @param deletedFlag
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag == null ? null : deletedFlag.trim();
    }

    /**
     * @return OPERATION_NAME
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * @param operationName
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
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
        sb.append(", remark=").append(remark);
        sb.append(", createBy=").append(createBy);
        sb.append(", lastModifiedBy=").append(lastModifiedBy);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modificationNum=").append(modificationNum);
        sb.append(", deletedFlag=").append(deletedFlag);
        sb.append(", operationName=").append(operationName);
        sb.append(", userName=").append(userName);
        sb.append(", businessName=").append(businessName);
        sb.append(", className=").append(className);
        sb.append(", methodName=").append(methodName);
        sb.append(", message=").append(message);
        sb.append("]");
        return sb.toString();
    }
}