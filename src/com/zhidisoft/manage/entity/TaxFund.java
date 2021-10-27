package com.zhidisoft.manage.entity;

import java.util.Date;

/**
 * 1 任务编号 id int 主键
 * 2 纳税人id payerId int 
 * 3 任务名称 taskName varchar(128)
 * 4 下达部门 taxOrganId int
 * 5 批准人 approverId int 
 * 6 执行人员 executeId int 
 * 7 执行时间 executeTime Date
 * 8 任务来源 taskFrom Varchar(12)
 * 9 任务执行情况 taskState Varchar(128)
 * 10 调查结论或意见 idea Varchar(512)
 * 11 风险等级 riskLevel int
 * 12 录入日期 recordDate Date
 * 13 录入人员 recordUserId int 关联tb_user
 * @<code>税源基础信息表（tb_tax_source）</code>
 * **/
public class TaxFund {
    private int id;
    private int payerId;
    private String taskName;
    private int subOrganId;
    private int approverId;
    private int executeId;
    private String executeTime;
    private String taskFrom;
    private String taskState;
    private String idea;
    private int riskLevel;
    private String recordDate;
    private int recordUserId;

    public TaxFund() {
    }

    public TaxFund(int id, int payerId, String taskName, int subOrganId, int approverId, int executeId, String executeTime, String taskFrom, String taskState, String idea, int riskLevel, String recordDate, int recordUserId) {
        this.id = id;
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskFrom = taskFrom;
        this.taskState = taskState;
        this.idea = idea;
        this.riskLevel = riskLevel;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getSubOrganId() {
        return subOrganId;
    }

    public void setSubOrganId(int subOrganId) {
        this.subOrganId = subOrganId;
    }

    public int getApproverId() {
        return approverId;
    }

    public void setApproverId(int approverId) {
        this.approverId = approverId;
    }

    public int getExecuteId() {
        return executeId;
    }

    public void setExecuteId(int executeId) {
        this.executeId = executeId;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(String taskFrom) {
        this.taskFrom = taskFrom;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
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
        return "TaxFund{" +
                "id=" + id +
                ", payerId=" + payerId +
                ", taskName='" + taskName + '\'' +
                ", subOrganId=" + subOrganId +
                ", approverId=" + approverId +
                ", executeId=" + executeId +
                ", executeTime='" + executeTime + '\'' +
                ", taskFrom='" + taskFrom + '\'' +
                ", taskState='" + taskState + '\'' +
                ", idea='" + idea + '\'' +
                ", riskLevel=" + riskLevel +
                ", recordDate='" + recordDate + '\'' +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
