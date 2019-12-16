package com.dorm.entity;

public class Apply {

    //主键id
    private Integer apply_id;
    //学号
    private String s_num;
    //名字
    private String s_name;
    //性别
    private String s_sex;
    //年龄
    private Integer s_age;
    //住址
    private String s_address;
    //宿舍
    private Integer dorm_num;
    //班级
    private String s_class;
    //是否通过
    private Integer is_pass;

    public Integer getIs_pass() {
        return is_pass;
    }

    public void setIs_pass(Integer is_pass) {
        this.is_pass = is_pass;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public String getS_num() {
        return s_num;
    }

    public void setS_num(String s_num) {
        this.s_num = s_num;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public Integer getS_age() {
        return s_age;
    }

    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public Integer getDorm_num() {
        return dorm_num;
    }

    public void setDorm_num(Integer dorm_num) {
        this.dorm_num = dorm_num;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }
}
