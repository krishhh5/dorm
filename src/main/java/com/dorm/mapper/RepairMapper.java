package com.dorm.mapper;

import com.dorm.entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("dorm_id") Integer dorm_id);
    //获取用户列表
    public List<Repair> getDormRepairList(@Param("dorm_id") Integer dorm_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addDormRepair(Repair dormrepair);    //添加宿舍信息
    public int deleteDormRepair(Integer r_id);   //删除宿舍信息
    public int updateDormRepair(Repair dormrepair); //修改宿舍信息
    public Repair findDormRepairById(Integer r_id);
    public List<Repair> getAll();
    public List<Repair> findRepair(@Param("dorm_id") Integer dorm_id);
    public List<Repair> getToRepair();
}
