package com.zhidisoft.manage.entity;

import javax.servlet.http.Part;
import java.util.Date;

/**
 * 1 行业编号 id Int 主键
 * 2 行业名称 industryName Varchar(64)
 * 3 录入日期 recordDate Date
 * 4 录入人员 recordUserId int
 * @<code>行业代码表（tb_industry）</code>
 * **/
public class Industry {
    private int id;
    private String industryName;
    private String recordDate;
    private int recordUserId;

    public Industry(int id, String industryName, String recordDate, int recordUserId) {
        this.id = id;
        this.industryName = industryName;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public Industry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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
        return "Industry{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                ", recordDate=" + recordDate +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
