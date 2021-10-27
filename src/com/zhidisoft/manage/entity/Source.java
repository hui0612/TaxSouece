package com.zhidisoft.manage.entity;

public class Source {
    private int id;//id
    private String taskName;//任务名称 s
    private String payerCode;//纳税人识别号p
    private String payerName;//纳税人名称p
    private String industryName;//行业i
    private String industryId;//行业id
    private String subOrganId;//税务机关id
    private String organName ;//税务机关
    private String bizScope;//经营范围p
    private String executeTime;//执行时间s
    private String recordTaskDate;//录入时间s
    private String timeOutfrom;//超时时间



    public Source() {
    }

    public Source(int id, String taskName, String payerCode, String payerName, String industryName, String industryId, String subOrganId, String organName, String bizScope, String executeTime, String recordTaskDate, String timeOutfrom) {
        this.id = id;
        this.taskName = taskName;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.industryName = industryName;
        this.industryId = industryId;
        this.subOrganId = subOrganId;
        this.organName = organName;
        this.bizScope = bizScope;
        this.executeTime = executeTime;
        this.recordTaskDate = recordTaskDate;
        this.timeOutfrom = timeOutfrom;
    }

    public Source(int id, String taskName, String payerCode, String payerName, String industryName, String bizScope, String executeTime, String recordTaskDate) {
        this.id = id;
        this.taskName = taskName;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.industryName = industryName;
        this.bizScope = bizScope;
        this.executeTime = executeTime;
        this.recordTaskDate = recordTaskDate;
    }

    public String getTimeOutfrom() {
        return timeOutfrom;
    }

    public void setTimeOutfrom(String timeOutfrom) {
        this.timeOutfrom = timeOutfrom;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getSubOrganId() {
        return subOrganId;
    }

    public void setSubOrganId(String subOrganId) {
        this.subOrganId = subOrganId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getRecordTaskDate() {
        return recordTaskDate;
    }

    public void setRecordTaskDate(String recordTaskDate) {
        this.recordTaskDate = recordTaskDate;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", industryName='" + industryName + '\'' +
                ", industryId='" + industryId + '\'' +
                ", subOrganId='" + subOrganId + '\'' +
                ", organName='" + organName + '\'' +
                ", bizScope='" + bizScope + '\'' +
                ", executeTime='" + executeTime + '\'' +
                ", recordTaskDate='" + recordTaskDate + '\'' +
                ", timeOutfrom='" + timeOutfrom + '\'' +
                '}';
    }
}
