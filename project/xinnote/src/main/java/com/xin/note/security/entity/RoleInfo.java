package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ROLE_INFO")
public class RoleInfo extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_ROLE_INFO.nextval from dual")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "USING_FLAG")
    private String usingFlag;

    @Column(name = "DELETED_FLAG")
    private String deletedFlag;

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date gmtModified;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;

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
     * @return ROLE_NAME
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", usingFlag=").append(usingFlag);
        sb.append(", deletedFlag=").append(deletedFlag);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", createBy=").append(createBy);
        sb.append(", lastModifiedBy=").append(lastModifiedBy);
        sb.append(", remark=").append(remark);
        sb.append(", modificationNum=").append(modificationNum);
        sb.append("]");
        return sb.toString();
    }
}