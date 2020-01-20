package com.glodon.easyshow.schedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "sche_job_info")
public class ScheJobInfo {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "job_key")
    private String jobKey;

    @Column(name = "job_class")
    private String jobClass;

    @Column(name = "create_date")
    private java.sql.Timestamp createDate;

    @Column(name = "update_date")
    private java.sql.Timestamp updateDate;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobKey() {
        return this.jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    public String getJobClass() {
        return this.jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public java.sql.Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.sql.Timestamp createDate) {
        this.createDate = createDate;
    }

    public java.sql.Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.sql.Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
