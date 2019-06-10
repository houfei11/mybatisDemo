package com.csdn.demo.entity;

import java.util.Date;

public class Personal {

    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String school;
    private Date stuTime;

    @Override
    public String toString() {
        return "Personal{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", school='" + school + '\'' +
                ", stuTime=" + stuTime +
                '}';
    }

    public Personal() {
    }

    public Personal(Integer stuId, String stuName, Integer stuAge, String school, Date stuTime) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.school = school;
        this.stuTime = stuTime;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getStuTime() {
        return stuTime;
    }

    public void setStuTime(Date stuTime) {
        this.stuTime = stuTime;
    }
}
