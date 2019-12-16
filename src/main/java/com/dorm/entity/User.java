package com.dorm.entity;

public class User {
    private static final long serialVersionUID = 1L;
    //用户id
    private Integer user_id;
    //用户名
    private String user_name;
    //名字
    private String name;
    //用户密码
    private String user_pass;
    //用户权限
    private Integer user_right;
    //用户年龄
    private Integer student_age;
    //学生性别
    private String student_sex;
    //学生地址
    private String student_address;
    //宿舍id
    private Integer dorm_id;
    //学生班级
    private String student_class;

    public User() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public User(Integer user_id, String user_name, String name, String user_pass, Integer user_right, Integer student_age, String student_sex, String student_address, Integer dorm_id, String student_class) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.name = name;
        this.user_pass = user_pass;
        this.user_right = user_right;
        this.student_age = student_age;
        this.student_sex = student_sex;
        this.student_address = student_address;
        this.dorm_id = dorm_id;
        this.student_class = student_class;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public Integer getUser_right() {
        return user_right;
    }

    public void setUser_right(Integer user_right) {
        this.user_right = user_right;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public Integer getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(Integer dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }
}
