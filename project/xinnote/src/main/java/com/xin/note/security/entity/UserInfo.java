package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "USER_INFO")
public class UserInfo extends EntityBean<Long> implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_USER_INFO.nextval from dual")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TYPE")
    private Long type;

    @Column(name = "LAST_LOGIN_IP")
    private String lastLoginIp;

    @Column(name = "CURRENT_LOGIN_IP")
    private String currentLoginIp;

    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @Column(name = "LOGIN_ATTEMPT_TIMES")
    private Long loginAttemptTimes;

    @Column(name = "LOGIN_FAILD_TIME")
    private Date loginFaildTime;

    @Column(name = "PASSWORD_FIRST_MODIFIED_FLAG")
    private Long passwordFirstModifiedFlag;

    @Column(name = "PASSWORD_EXPIRE_TIME")
    private Date passwordExpireTime;

    @Column(name = "TELEPHONE")
    private String telephone;

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

    @Column(name = "ENCODE")
    private String encode;

    @Column(name = "EXPIRED_TIME")
    private Date expiredTime;

    @Column(name = "HAVE_IMAGE_FLAG")
    private String haveImageFlag;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "SIGN_IMAGE")
    private byte[] signImage;

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
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
     * @return LAST_LOGIN_IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * @return CURRENT_LOGIN_IP
     */
    public String getCurrentLoginIp() {
        return currentLoginIp;
    }

    /**
     * @param currentLoginIp
     */
    public void setCurrentLoginIp(String currentLoginIp) {
        this.currentLoginIp = currentLoginIp == null ? null : currentLoginIp.trim();
    }

    /**
     * @return LAST_LOGIN_TIME
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return LOGIN_ATTEMPT_TIMES
     */
    public Long getLoginAttemptTimes() {
        return loginAttemptTimes;
    }

    /**
     * @param loginAttemptTimes
     */
    public void setLoginAttemptTimes(Long loginAttemptTimes) {
        this.loginAttemptTimes = loginAttemptTimes;
    }

    /**
     * @return LOGIN_FAILD_TIME
     */
    public Date getLoginFaildTime() {
        return loginFaildTime;
    }

    /**
     * @param loginFaildTime
     */
    public void setLoginFaildTime(Date loginFaildTime) {
        this.loginFaildTime = loginFaildTime;
    }

    /**
     * @return PASSWORD_FIRST_MODIFIED_FLAG
     */
    public Long getPasswordFirstModifiedFlag() {
        return passwordFirstModifiedFlag;
    }

    /**
     * @param passwordFirstModifiedFlag
     */
    public void setPasswordFirstModifiedFlag(Long passwordFirstModifiedFlag) {
        this.passwordFirstModifiedFlag = passwordFirstModifiedFlag;
    }

    /**
     * @return PASSWORD_EXPIRE_TIME
     */
    public Date getPasswordExpireTime() {
        return passwordExpireTime;
    }

    /**
     * @param passwordExpireTime
     */
    public void setPasswordExpireTime(Date passwordExpireTime) {
        this.passwordExpireTime = passwordExpireTime;
    }

    /**
     * @return TELEPHONE
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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
     * @return ENCODE
     */
    public String getEncode() {
        return encode;
    }

    /**
     * @param encode
     */
    public void setEncode(String encode) {
        this.encode = encode == null ? null : encode.trim();
    }

    /**
     * @return EXPIRED_TIME
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * @param expiredTime
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * @return HAVE_IMAGE_FLAG
     */
    public String getHaveImageFlag() {
        return haveImageFlag;
    }

    /**
     * @param haveImageFlag
     */
    public void setHaveImageFlag(String haveImageFlag) {
        this.haveImageFlag = haveImageFlag == null ? null : haveImageFlag.trim();
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
     * @return SIGN_IMAGE
     */
    public byte[] getSignImage() {
        return signImage;
    }

    /**
     * @param signImage
     */
    public void setSignImage(byte[] signImage) {
        this.signImage = signImage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", type=").append(type);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", currentLoginIp=").append(currentLoginIp);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", loginAttemptTimes=").append(loginAttemptTimes);
        sb.append(", loginFaildTime=").append(loginFaildTime);
        sb.append(", passwordFirstModifiedFlag=").append(passwordFirstModifiedFlag);
        sb.append(", passwordExpireTime=").append(passwordExpireTime);
        sb.append(", telephone=").append(telephone);
        sb.append(", usingFlag=").append(usingFlag);
        sb.append(", deletedFlag=").append(deletedFlag);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", createBy=").append(createBy);
        sb.append(", lastModifiedBy=").append(lastModifiedBy);
        sb.append(", encode=").append(encode);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", haveImageFlag=").append(haveImageFlag);
        sb.append(", remark=").append(remark);
        sb.append(", modificationNum=").append(modificationNum);
        sb.append(", userName=").append(userName);
        sb.append(", signImage=").append(signImage);
        sb.append("]");
        return sb.toString();
    }
}