package com.zhidisoft.manage.entity;

public class TaxPayer1 {
    private int id;
    private String payerCode;//纳税人识别号
    private String payerName;//纳税人名称
    private String organName;//所属税务机关
    private String industryName;//所属行业
    private String legalPerson;//法人代表
    private String legalIdCard;//法人身份证号码
    private String finaceName;//主管财务
    private String finaceIdCard;//财务身份证号码
    private String recordDate;//录入日期
    private String bizAddress ; //生产经营地址
    private String bizScope; //生产经营范围
    private String legalIdCardImageURL ;//法人身份证照片
    private String taxerName ;//录入人员
    private String bizAddressPhone ;//生产经营地电话
    private String invoiceType ;//票种核定
    private String finaceIdCardImageURL;//财务身份证号

    public TaxPayer1(String organName,String industryName,String invoiceType ) {
        this.organName = organName;
        this.industryName = industryName;
        this.invoiceType  = invoiceType ;
    }

    public TaxPayer1(int id, String payerCode, String payerName, String organName, String industryName, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String recordDate, String bizAddress, String bizScope, String legalIdCardImageURL, String taxerName, String bizAddressPhone, String invoiceType , String finaceIdCardImageURL) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.organName = organName;
        this.industryName = industryName;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.recordDate = recordDate;
        this.bizAddress = bizAddress;
        this.bizScope = bizScope;
        this.legalIdCardImageURL = legalIdCardImageURL;
        this.taxerName = taxerName;
        this.bizAddressPhone = bizAddressPhone;
        this.invoiceType  = invoiceType ;
        this.finaceIdCardImageURL = finaceIdCardImageURL;
    }
    public TaxPayer1(){

    }
    public TaxPayer1(int id, String payerCode, String payerName, String organName, String industryName, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String recordDate) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.organName = organName;
        this.industryName = industryName;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.recordDate = recordDate;
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

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getBizAddress() {
        return bizAddress;
    }

    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getLegalIdCardImageURL() {
        return legalIdCardImageURL;
    }

    public void setLegalIdCardImageURL(String legalIdCardImageURL) {
        this.legalIdCardImageURL = legalIdCardImageURL;
    }

    public String getTaxerName() {
        return taxerName;
    }

    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    public String getBizAddressPhone() {
        return bizAddressPhone;
    }

    public void setBizAddressPhone(String bizAddressPhone) {
        this.bizAddressPhone = bizAddressPhone;
    }

    public String getInvoiceType () {
        return invoiceType ;
    }

    public void setInvoiceType (String invoiceType ) {
        this.invoiceType  = invoiceType ;
    }

    public String getFinaceIdCardImageURL() {
        return finaceIdCardImageURL;
    }

    public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
        this.finaceIdCardImageURL = finaceIdCardImageURL;
    }

    @Override
    public String toString() {
        return "TaxPayer1{" +
                "id=" + id +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", organName='" + organName + '\'' +
                ", industryName='" + industryName + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalIdCard='" + legalIdCard + '\'' +
                ", finaceName='" + finaceName + '\'' +
                ", finaceIdCard='" + finaceIdCard + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", bizAddress='" + bizAddress + '\'' +
                ", bizScope='" + bizScope + '\'' +
                ", legalIdCardImageURL='" + legalIdCardImageURL + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", bizAddressPhone='" + bizAddressPhone + '\'' +
                ", invoiceType ='" + invoiceType  + '\'' +
                ", finaceIdCardImageURL='" + finaceIdCardImageURL + '\'' +
                '}';
    }
}
