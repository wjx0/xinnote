package com.xin.note.common;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据库实体类的基础类，凡是要存入数据库的bean均要继承此类，按照规范后台所有表中一定要有相应的字段
 */
public abstract class EntityBean<K extends Serializable> implements Serializable
{
    private static final long serialVersionUID = 2741604299092756219L;

    protected abstract K getId() ;

    protected abstract void setId(K id);

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

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;

    @Column(name = "REMARK")
    private String remark;

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getModificationNum() {
        return modificationNum;
    }

    public void setModificationNum(Integer modificationNum) {
        this.modificationNum = modificationNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
