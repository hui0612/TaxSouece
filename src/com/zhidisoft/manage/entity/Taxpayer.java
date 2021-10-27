package com.zhidisoft.manage.entity;

import java.util.Date;
/**
 * 主键 id int 主键
 * 1 纳税人识别号 payerCode varchar(32)
 * 2 纳税人名称 payerName varchar (64)
 * 3 生产经营地址 bizAddress varchar(128)
 * 4 所属税务机关 taxOrganid int
 * 5 行业 industryId int
 * 6 经营范围 bizScope Varchar(128)
 * 7票种核定 invoiceType varchar(12)
 * 8 法人代表 legalPerson varchar(32)
 * 9 身份号码 legalIdCard Varchar(20)
 * 10 手机号码 legalMobile Varchar(12)
 * 11 法人代表身份证扫描图片 legalIdCardImageURL Varchar(64)
 * 12 财务人员 finaceName varchar(32)
 * 13 财务人员身份号码 finaceIdCard Varchar(20)
 * 14 财务人员手机号码 finaceMobile Varchar(12)
 * 15 财务人员身份证扫描图片 finaceIdCardImageURL Varchar(64)
 * 16 办税人员 taxerName varchar(32)
 * 17 办税人员身份号码 taxerIdCard Varchar(20)
 * 18 办税人员手机号码 taxerMobile Varchar(12)
 * 19 办税人员身份证扫描图片 taxerIdCardImageURL Varchar(64)
 * 20 生产经营地电话 bizAddressPhone Varchar(12)
 * 21 录入日期 recordDate Date
 * 22 录入人员 userId int 关联tb_use
 * 纳税人信息表（tb_tax_payer）
 * @<code>Taxpayer</code>
 * **/
public class Taxpayer {
    private int id;
    private String payerCode;
    private String payerName;
    private String bizAddress;
    private int taxOrganId;
    private int industryId;
    private String bizScope;
    private String invoiceType;
    private String legalPerson;
    private String legalIdCard;
    private String legalMobile;
    private String legalIdCardImageURL;
    private String finaceName;
    private String finaceIdCard;
    private String finaceMobile;
    private String finaceIdCardImageURL;
    private String taxerName;
    private String taxerIdCard;
    private String taxerMobile;
    private String taxerIdCardImageURL;
    private String bizAddressPhone;
    private String recordDate;
    private Integer removeState = 0;
    private int userId;

    public Taxpayer() {
    }

    public Taxpayer(int id, String payerCode, String payerName, String bizAddress, int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String legalMobile, String legalIdCardImageURL, String finaceName, String finaceIdCard, String finaceMobile, String finaceIdCardImageURL, String taxerName, String taxerIdCard, String taxerMobile, String taxerIdCardImageURL, String bizAddressPhone, String recordDate, Integer removeState, int userId) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.taxOrganId = taxOrganId;
        this.industryId = industryId;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.legalMobile = legalMobile;
        this.legalIdCardImageURL = legalIdCardImageURL;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.finaceMobile = finaceMobile;
        this.finaceIdCardImageURL = finaceIdCardImageURL;
        this.taxerName = taxerName;
        this.taxerIdCard = taxerIdCard;
        this.taxerMobile = taxerMobile;
        this.taxerIdCardImageURL = taxerIdCardImageURL;
        this.bizAddressPhone = bizAddressPhone;
        this.recordDate = recordDate;
        this.removeState = removeState;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getBizAddress() {
        return bizAddress;
    }

    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
    }

    public int getTaxOrganId() {
        return taxOrganId;
    }

    public void setTaxOrganId(int taxOrganId) {
        this.taxOrganId = taxOrganId;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalIdCard() {
        return legalIdCard;
    }

    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
    }

    public String getLegalMobile() {
        return legalMobile;
    }

    public void setLegalMobile(String legalMobile) {
        this.legalMobile = legalMobile;
    }

    public String getLegalIdCardImageURL() {
        return legalIdCardImageURL;
    }

    public void setLegalIdCardImageURL(String legalIdCardImageURL) {
        this.legalIdCardImageURL = legalIdCardImageURL;
    }

    public String getFinaceName() {
        return finaceName;
    }

    public void setFinaceName(String finaceName) {
        this.finaceName = finaceName;
    }

    public String getFinaceIdCard() {
        return finaceIdCard;
    }

    public void setFinaceIdCard(String finaceIdCard) {
        this.finaceIdCard = finaceIdCard;
    }

    public String getFinaceMobile() {
        return finaceMobile;
    }

    public void setFinaceMobile(String finaceMobile) {
        this.finaceMobile = finaceMobile;
    }

    public String getFinaceIdCardImageURL() {
        return finaceIdCardImageURL;
    }

    public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
        this.finaceIdCardImageURL = finaceIdCardImageURL;
    }

    public String getTaxerName() {
        return taxerName;
    }

    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    public String getTaxerIdCard() {
        return taxerIdCard;
    }

    public void setTaxerIdCard(String taxerIdCard) {
        this.taxerIdCard = taxerIdCard;
    }

    public String getTaxerMobile() {
        return taxerMobile;
    }

    public void setTaxerMobile(String taxerMobile) {
        this.taxerMobile = taxerMobile;
    }

    public String getTaxerIdCardImageURL() {
        return taxerIdCardImageURL;
    }

    public void setTaxerIdCardImageURL(String taxerIdCardImageURL) {
        this.taxerIdCardImageURL = taxerIdCardImageURL;
    }

    public String getBizAddressPhone() {
        return bizAddressPhone;
    }

    public void setBizAddressPhone(String bizAddressPhone) {
        this.bizAddressPhone = bizAddressPhone;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getRemoveState() {
        return removeState;
    }

    public void setRemoveState(Integer removeState) {
        this.removeState = removeState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Taxpayer{" +
                "id=" + id +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", bizAddress='" + bizAddress + '\'' +
                ", taxOrganId=" + taxOrganId +
                ", industryId=" + industryId +
                ", bizScope='" + bizScope + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalIdCard='" + legalIdCard + '\'' +
                ", legalMobile='" + legalMobile + '\'' +
                ", legalIdCardImageURL='" + legalIdCardImageURL + '\'' +
                ", finaceName='" + finaceName + '\'' +
                ", finaceIdCard='" + finaceIdCard + '\'' +
                ", finaceMobile='" + finaceMobile + '\'' +
                ", finaceIdCardImageURL='" + finaceIdCardImageURL + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", taxerIdCard='" + taxerIdCard + '\'' +
                ", taxerMobile='" + taxerMobile + '\'' +
                ", taxerIdCardImageURL='" + taxerIdCardImageURL + '\'' +
                ", bizAddressPhone='" + bizAddressPhone + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", removeState=" + removeState +
                ", userId=" + userId +
                '}';
    }
}
