package com.dorm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Visitor {
    private static final long serialVersionUID = 1L;
    private Integer visitor_id;
    private String visitor_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;
    private String remark;
    private Integer phone;

    public Visitor() {
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(Integer visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
