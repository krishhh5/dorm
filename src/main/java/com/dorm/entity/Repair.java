package com.dorm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Repair {
    private Integer repair_id;
    private Integer dorm_id;
    private String details;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date begin_time;
    private Integer checked;
    private Integer is_repair;
    private String repair_name;

    public String getRepair_name() {
        return repair_name;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public void setRepair_name(String repair_name) {
        this.repair_name = repair_name;
    }

    public Repair() {
    }

    public Integer getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Integer repair_id) {
        this.repair_id = repair_id;
    }

    public Integer getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(Integer dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }


    public Integer getIs_repair() {
        return is_repair;
    }

    public void setIs_repair(Integer is_repair) {
        this.is_repair = is_repair;
    }
}
