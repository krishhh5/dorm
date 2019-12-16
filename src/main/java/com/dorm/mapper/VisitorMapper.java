package com.dorm.mapper;

import com.dorm.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("visitor_name") String visitor_name);
    //获取用户列表
    public List<Visitor> getVisitorList(@Param("visitor_name") String visitor_name, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addVisitor(Visitor visitor);   //添加游客信息
    public List<Visitor> getAll();
}
