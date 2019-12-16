package com.dorm.mapper;

import com.dorm.entity.Dorm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("dorm_num") Integer dorm_num);
    //获取用户列表
    public List<Dorm> getDormitoryList(@Param("dorm_num") Integer dorm_num, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addDormitory(Dorm dormitory);    //添加宿舍信息
    public int deleteDormitory(Integer dorm_id);   //删除宿舍信息
    public int updateDormitory(Dorm dormitory); //修改宿舍信息
    public Dorm findDormitoryById(Integer dorm_id);

    public List<Dorm> findDormitoryStudent(Dorm dormitory); //查询宿舍人员信息
    public List<Dorm> getAll();
    //查询空宿舍
    public List<Dorm> getEmptyDorm();
    //分配宿舍
    public int arrangeDorm(@Param("dorm_num")Integer dorm_num,@Param("bed_num")Integer bed_num);
    //
    public int findBedNum(@Param("dorm_num")Integer dorm_num);

}
