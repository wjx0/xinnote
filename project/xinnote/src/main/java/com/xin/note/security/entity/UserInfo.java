package com.xin.note.security.entity;

import com.xin.note.common.EntityBean;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TYPE")
    private Long type;

    @Column(name = "NICK_NAME")
    private String nickName;

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

    @Column(name = "LANGUAGE_ID")
    private Long languageId;

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "TIMEZONE_ID")
    private Long timezoneId;

    @Column(name = "TIMEZONE_CODE")
    private String timezoneCode;

    @Column(name = "TELEPHONE_NUM")
    private String telephoneNum;

    @Column(name = "POSITION_ID")
    private Long positionId;

    @Column(name = "POSITION_CLASSIFY_CODE")
    private String positionClassifyCode;

    @Column(name = "BD_UNIT_ID")
    private Long bdUnitId;

    @Column(name = "BD_ORG_ID")
    private Long bdOrgId;

    @Column(name = "FM_ORG_ID")
    private Long fmOrgId;

    @Column(name = "ADM_ORG_ID")
    private Long admOrgId;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "JOB_NO")
    private String jobNo;

    @Column(name = "IS_RECHG_FLAG")
    private String isRechgFlag;

    @Column(name = "USING_FLAG")
    private String usingFlag;

    @Column(name = "ENCODE")
    private String encode;

    @Column(name = "EXPIRED_TIME")
    private Date expiredTime;

    @Column(name = "PASSPORT_NO")
    private String passportNo;

    @Column(name = "HAVE_IMAGE_FLAG")
    private String haveImageFlag;

    @Column(name = "LEADER_ID")
    private BigDecimal leaderId;

    @Column(name = "HAVE_PHOTO_FLAG")
    private String havePhotoFlag;

    @Column(name = "CLASSIFY_LEVEL")
    private String classifyLevel;

    @Column(name = "SAP_ORDER")
    private String sapOrder;

    @Column(name = "LEADER_BU")
    private BigDecimal leaderBu;

    @Column(name = "QUERY_SELF_FLAG")
    private String querySelfFlag;

    @Column(name = "VERSION_FLAG")
    private String versionFlag;

    @Column(name = "PASSPORT_EXPIRED_DATE")
    private Date passportExpiredDate;

    @Column(name = "HR_CODE")
    private String hrCode;

    @Column(name = "HR_NAME")
    private Object hrName;

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
     * @return NICK_NAME
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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
     * @return LANGUAGE_ID
     */
    public Long getLanguageId() {
        return languageId;
    }

    /**
     * @param languageId
     */
    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    /**
     * @return LANGUAGE_CODE
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * @param languageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode == null ? null : languageCode.trim();
    }

    /**
     * @return TIMEZONE_ID
     */
    public Long getTimezoneId() {
        return timezoneId;
    }

    /**
     * @param timezoneId
     */
    public void setTimezoneId(Long timezoneId) {
        this.timezoneId = timezoneId;
    }

    /**
     * @return TIMEZONE_CODE
     */
    public String getTimezoneCode() {
        return timezoneCode;
    }

    /**
     * @param timezoneCode
     */
    public void setTimezoneCode(String timezoneCode) {
        this.timezoneCode = timezoneCode == null ? null : timezoneCode.trim();
    }

    /**
     * @return TELEPHONE_NUM
     */
    public String getTelephoneNum() {
        return telephoneNum;
    }

    /**
     * @param telephoneNum
     */
    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum == null ? null : telephoneNum.trim();
    }

    /**
     * @return POSITION_ID
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     * @return POSITION_CLASSIFY_CODE
     */
    public String getPositionClassifyCode() {
        return positionClassifyCode;
    }

    /**
     * @param positionClassifyCode
     */
    public void setPositionClassifyCode(String positionClassifyCode) {
        this.positionClassifyCode = positionClassifyCode == null ? null : positionClassifyCode.trim();
    }

    /**
     * @return BD_UNIT_ID
     */
    public Long getBdUnitId() {
        return bdUnitId;
    }

    /**
     * @param bdUnitId
     */
    public void setBdUnitId(Long bdUnitId) {
        this.bdUnitId = bdUnitId;
    }

    /**
     * @return BD_ORG_ID
     */
    public Long getBdOrgId() {
        return bdOrgId;
    }

    /**
     * @param bdOrgId
     */
    public void setBdOrgId(Long bdOrgId) {
        this.bdOrgId = bdOrgId;
    }

    /**
     * @return FM_ORG_ID
     */
    public Long getFmOrgId() {
        return fmOrgId;
    }

    /**
     * @param fmOrgId
     */
    public void setFmOrgId(Long fmOrgId) {
        this.fmOrgId = fmOrgId;
    }

    /**
     * @return ADM_ORG_ID
     */
    public Long getAdmOrgId() {
        return admOrgId;
    }

    /**
     * @param admOrgId
     */
    public void setAdmOrgId(Long admOrgId) {
        this.admOrgId = admOrgId;
    }

    /**
     * @return VENDOR_CODE
     */
    public String getVendorCode() {
        return vendorCode;
    }

    /**
     * @param vendorCode
     */
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode == null ? null : vendorCode.trim();
    }

    /**
     * @return JOB_NO
     */
    public String getJobNo() {
        return jobNo;
    }

    /**
     * @param jobNo
     */
    public void setJobNo(String jobNo) {
        this.jobNo = jobNo == null ? null : jobNo.trim();
    }

    /**
     * @return IS_RECHG_FLAG
     */
    public String getIsRechgFlag() {
        return isRechgFlag;
    }

    /**
     * @param isRechgFlag
     */
    public void setIsRechgFlag(String isRechgFlag) {
        this.isRechgFlag = isRechgFlag == null ? null : isRechgFlag.trim();
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
     * @return PASSPORT_NO
     */
    public String getPassportNo() {
        return passportNo;
    }

    /**
     * @param passportNo
     */
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo == null ? null : passportNo.trim();
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
     * @return LEADER_ID
     */
    public BigDecimal getLeaderId() {
        return leaderId;
    }

    /**
     * @param leaderId
     */
    public void setLeaderId(BigDecimal leaderId) {
        this.leaderId = leaderId;
    }

    /**
     * @return HAVE_PHOTO_FLAG
     */
    public String getHavePhotoFlag() {
        return havePhotoFlag;
    }

    /**
     * @param havePhotoFlag
     */
    public void setHavePhotoFlag(String havePhotoFlag) {
        this.havePhotoFlag = havePhotoFlag == null ? null : havePhotoFlag.trim();
    }

    /**
     * @return CLASSIFY_LEVEL
     */
    public String getClassifyLevel() {
        return classifyLevel;
    }

    /**
     * @param classifyLevel
     */
    public void setClassifyLevel(String classifyLevel) {
        this.classifyLevel = classifyLevel == null ? null : classifyLevel.trim();
    }

    /**
     * @return SAP_ORDER
     */
    public String getSapOrder() {
        return sapOrder;
    }

    /**
     * @param sapOrder
     */
    public void setSapOrder(String sapOrder) {
        this.sapOrder = sapOrder == null ? null : sapOrder.trim();
    }

    /**
     * @return LEADER_BU
     */
    public BigDecimal getLeaderBu() {
        return leaderBu;
    }

    /**
     * @param leaderBu
     */
    public void setLeaderBu(BigDecimal leaderBu) {
        this.leaderBu = leaderBu;
    }

    /**
     * @return QUERY_SELF_FLAG
     */
    public String getQuerySelfFlag() {
        return querySelfFlag;
    }

    /**
     * @param querySelfFlag
     */
    public void setQuerySelfFlag(String querySelfFlag) {
        this.querySelfFlag = querySelfFlag == null ? null : querySelfFlag.trim();
    }

    /**
     * @return VERSION_FLAG
     */
    public String getVersionFlag() {
        return versionFlag;
    }

    /**
     * @param versionFlag
     */
    public void setVersionFlag(String versionFlag) {
        this.versionFlag = versionFlag == null ? null : versionFlag.trim();
    }

    /**
     * @return PASSPORT_EXPIRED_DATE
     */
    public Date getPassportExpiredDate() {
        return passportExpiredDate;
    }

    /**
     * @param passportExpiredDate
     */
    public void setPassportExpiredDate(Date passportExpiredDate) {
        this.passportExpiredDate = passportExpiredDate;
    }

    /**
     * @return HR_CODE
     */
    public String getHrCode() {
        return hrCode;
    }

    /**
     * @param hrCode
     */
    public void setHrCode(String hrCode) {
        this.hrCode = hrCode == null ? null : hrCode.trim();
    }

    /**
     * @return HR_NAME
     */
    public Object getHrName() {
        return hrName;
    }

    /**
     * @param hrName
     */
    public void setHrName(Object hrName) {
        this.hrName = hrName;
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
        sb.append(", status=").append(status);
        sb.append(", email=").append(email);
        sb.append(", type=").append(type);
        sb.append(", nickName=").append(nickName);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", currentLoginIp=").append(currentLoginIp);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", loginAttemptTimes=").append(loginAttemptTimes);
        sb.append(", loginFaildTime=").append(loginFaildTime);
        sb.append(", passwordFirstModifiedFlag=").append(passwordFirstModifiedFlag);
        sb.append(", passwordExpireTime=").append(passwordExpireTime);
        sb.append(", languageId=").append(languageId);
        sb.append(", languageCode=").append(languageCode);
        sb.append(", timezoneId=").append(timezoneId);
        sb.append(", timezoneCode=").append(timezoneCode);
        sb.append(", telephoneNum=").append(telephoneNum);
        sb.append(", positionId=").append(positionId);
        sb.append(", positionClassifyCode=").append(positionClassifyCode);
        sb.append(", bdUnitId=").append(bdUnitId);
        sb.append(", bdOrgId=").append(bdOrgId);
        sb.append(", fmOrgId=").append(fmOrgId);
        sb.append(", admOrgId=").append(admOrgId);
        sb.append(", vendorCode=").append(vendorCode);
        sb.append(", jobNo=").append(jobNo);
        sb.append(", isRechgFlag=").append(isRechgFlag);
        sb.append(", usingFlag=").append(usingFlag);
        sb.append(", encode=").append(encode);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", passportNo=").append(passportNo);
        sb.append(", haveImageFlag=").append(haveImageFlag);
        sb.append(", leaderId=").append(leaderId);
        sb.append(", havePhotoFlag=").append(havePhotoFlag);
        sb.append(", classifyLevel=").append(classifyLevel);
        sb.append(", sapOrder=").append(sapOrder);
        sb.append(", leaderBu=").append(leaderBu);
        sb.append(", querySelfFlag=").append(querySelfFlag);
        sb.append(", versionFlag=").append(versionFlag);
        sb.append(", passportExpiredDate=").append(passportExpiredDate);
        sb.append(", hrCode=").append(hrCode);
        sb.append(", hrName=").append(hrName);
        sb.append(", signImage=").append(signImage);
        sb.append("]");
        return sb.toString();
    }
}