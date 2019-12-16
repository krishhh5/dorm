package com.dorm.service;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Visitor;
import java.util.List;

public interface VisitorService {
    //分页查询
    public PageInfo<Visitor> findPageInfo(String visitor_name, Integer pageIndex, Integer pageSize);
    public int addVisitor(Visitor visitor);   //添加访客信息
    public List<Visitor> getAll();
}
