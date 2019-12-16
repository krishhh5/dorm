package com.dorm.service;

import com.dorm.entity.Dorm;
import com.dorm.entity.PageInfo;

import java.util.List;

public interface DormService {
    //分页查询
    public PageInfo<Dorm> findPageInfo(Integer dorm_num,  Integer pageIndex, Integer pageSize);

    public int addDormitory(Dorm dormitory);    //添加宿舍信息
    public int deleteDormitory(Integer d_id);   //删除宿舍信息
    public int updateDormitory(Dorm dormitory); //修改宿舍信息
    public Dorm findDormitoryById(Integer d_id);

    public List<Dorm> findDormitoryStudent(Dorm dormitory);//查询宿舍人员信息
    //获得所有宿舍列表
    public List<Dorm> getAll();
    //获得空宿舍表
    public List<Dorm> getEmptyDorm();
    //分配宿舍
    public int arrangeDorm(Integer dorm_num,Integer bed_num);
    //根据宿舍号查找宿舍床位已用数
    public int findBedNum(Integer dorm_num);
}
