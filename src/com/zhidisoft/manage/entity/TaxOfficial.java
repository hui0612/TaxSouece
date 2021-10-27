package com.zhidisoft.manage.entity;

import java.util.Date;

/**
 * 0 表主键 id int 主键自增
 * 1 税务人员工号 taxerCode varchar(12) not null unique
 * 2 税务人员名称 taxerName Varchar(32)
 * 3 税务人员电话 mobile Varchar(12)
 * 4 税务人员地址 address Varchar(128)
 * 5 税务人员性别 sex Varchar(2)
 * 6 出生日期 birthday Date
 * 7 电子邮件 email Varchar(64)
 * 8 所属税务机关 organId int 关联tb_tax_organ
 * 9 有效标志 state int 1:有效 0:无效 默认0
 * 10 上级领导 mgr int tb_taxer中税务工作人员
 * 11 系统管理员标志 admin Int 1代表是 0代表不是 默认为0
 * 12 录入日期 recordDate Date
 * 13 录入人员 recordUserId int
 * @<code>税务人员信息表（tb_taxer）</code>
 * **/
public class TaxOfficial {
    private int id;
    private String taxerCode;
    private String taxerName;
    private String mobile;
    private String address;
    private String sex;
    private String birthday;
    private String email;
    private int organId;
    private int state;
    private int mgr;
    private int admin;
    private String recordDate;
    private int recordUserId;

    public TaxOfficial() {
    }

    public TaxOfficial(int id, String taxerCode, String taxerName, String mobile, String address, String sex, String birthday, String email, int organId, int state, int mgr, int admin, String recordDate, int recordUserId) {
        this.id = id;
        this.taxerCode = taxerCode;
        this.taxerName = taxerName;
        this.mobile = mobile;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.organId = organId;
        this.state = state;
        this.mgr = mgr;
        this.admin = admin;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxerCode() {
        return taxerCode;
    }

    public void setTaxerCode(String taxerCode) {
        this.taxerCode = taxerCode;
    }

    public String getTaxerName() {
        return taxerName;
    }

    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
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
        return "TaxOfficial{" +
                "id=" + id +
                ", taxerCode='" + taxerCode + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", organId=" + organId +
                ", state=" + state +
                ", mgr=" + mgr +
                ", admin=" + admin +
                ", recordDate=" + recordDate +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
