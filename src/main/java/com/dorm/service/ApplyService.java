package com.dorm.service;

import com.dorm.entity.Apply;

import java.util.List;

public interface ApplyService {
    //增加申请表
    public int addApply(Apply apply);
    //根据名字
    public int findDorm(String user_name);
    //获得所有申请列表
    public List<Apply> getAll();
    //更新
    public int update(Apply apply);
    //根据id找到某一申请表
     Apply findApply(Integer id);
}
