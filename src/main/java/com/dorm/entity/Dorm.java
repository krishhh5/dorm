package com.dorm.entity;

import java.util.List;

public class Dorm {
    private static final long serialVersionUID = 1L;
    //宿舍id
    private Integer dorm_id;
    //宿舍号
    private Integer dorm_num;
    //床号
    private Integer bed_num;
    //床位数量
    private Integer bed_count;

    private List<User> user;

    public Dorm() {
    }


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(Integer dorm_id) {
        this.dorm_id = dorm_id;
    }

    public Integer getDorm_num() {
        return dorm_num;
    }

    public void setDorm_num(Integer dorm_num) {
        this.dorm_num = dorm_num;
    }

    public Integer getBed_num() {
        return bed_num;
    }

    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public Integer getBed_count() {
        return bed_count;
    }

    public void setBed_count(Integer bed_count) {
        this.bed_count = bed_count;
    }
}
