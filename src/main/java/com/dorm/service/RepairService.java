package com.dorm.service;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Repair;

import java.util.List;

public interface RepairService {
    //分页查询
    public PageInfo<Repair> findPageInfo(Integer dorm_id, Integer pageIndex, Integer pageSize);

    public int addDormRepair(Repair repair);    //添加宿舍信息
    public int deleteDormRepair(Integer repair_id);   //删除宿舍信息
    public int updateDormRepair(Repair repair); //修改宿舍信息
    public Repair findDormRepairById(Integer repair_id);
    public List<Repair> getAll();
    public List<Repair> findRepair(Integer dorm_id);
    public List<Repair> getToRepair();
}