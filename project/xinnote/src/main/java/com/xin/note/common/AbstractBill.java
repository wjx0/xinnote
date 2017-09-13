package com.xin.note.common;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author xin
 * 单据类基础类，抽象单据中通用的概念，比如预算单元，预算年月，申请人等等
 */
public abstract class AbstractBill extends EntityBean<Long>{
    //单据号
    @Column(name = "DOC_NO")
    private String docNo;
    //预算单元id
    @Column(name = "BD_UNIT_ID")
    private Long bdUnitId;
    //预算部门id
    @Column(name = "BD_ENTITY_ID")
    private Long bdEntityId;
    //业务日期，申请人可自行修改
    @Column(name = "BUSINESS_DATE")
    private Date businessDate;
    //币种id
    @Column(name = "CURRENCY_ID")
    private Long currencyId;
    //状态编码
    @Column(name = "STATUS_FLAG")
    private String statusFlag;
    //预算年度
    @Column(name = "FISCAL_YEAR")
    private Short fiscalYear;
    //预算月度
    @Column(name = "FISCAL_MONTH")
    private Short fiscalMonth;



    public Long getBdUnitId() {
        return bdUnitId;
    }

    public void setBdUnitId(Long bdUnitId) {
        this.bdUnitId = bdUnitId;
    }

    public Short getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Short fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Short getFiscalMonth() {
        return fiscalMonth;
    }

    public void setFiscalMonth(Short fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Long getBdEntityId() {
        return bdEntityId;
    }

    public void setBdEntityId(Long bdEntityId) {
        this.bdEntityId = bdEntityId;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }
}
