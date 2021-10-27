package com.zhidisoft.manage.entity;

import java.util.Date;

/**
 * 1 税务机关代码 id int 主键
 * 2 税务机关名称 organName varchar(64)
 * 3 上级税务机关代码 parentId int
 * 4 税务机关地址 address Varchar(128)
 * 5 税务机关联系电话 phone Varchar(12)
 * 6 传真电话 faxPhone Varchar(12)
 * 7 电子信箱 email Varchar(32)
 * 8 负责人 leaderId int 关联tb_taxer
 * 9 国地税类型代码 taxTypeCode Varchar(12)
 * 10 有效标志 state int 1:有效 0:无效 默认0
 * 11 录入日期 recordDate Date
 * 12 录入人员 recordUserId int
 * @<code>税务机关表（tb_tax_organ）</code>
 * **/
public class Office {
    private int id;
    private String organName;
    private int parentId;
    private String address;
    private String phone;
    private String faxPhone;
    private String email;
    private int leaderId;
    private String taxTypeCode;
    private int state;
    private String recordDate;
    private int recordUserId;

    public Office() {
    }

    public Office(int id, String organName, int parentId, String address, String phone, String faxPhone, String email, int leaderId, String taxTypeCode, int state, String recordDate, int recordUserId) {
        this.id = id;
        this.organName = organName;
        this.parentId = parentId;
        this.address = address;
        this.phone = phone;
        this.faxPhone = faxPhone;
        this.email = email;
        this.leaderId = leaderId;
        this.taxTypeCode = taxTypeCode;
        this.state = state;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(int recordUserId) {
        this.recordUserId = recordUserId;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", organName='" + organName + '\'' +
                ", parentId=" + parentId +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", faxPhone='" + faxPhone + '\'' +
                ", email='" + email + '\'' +
                ", leaderId=" + leaderId +
                ", taxTypeCode='" + taxTypeCode + '\'' +
                ", state=" + state +
                ", recordDate=" + recordDate +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
