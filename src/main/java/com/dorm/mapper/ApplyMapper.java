package com.dorm.mapper;

import com.dorm.entity.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyMapper {
    public int addApply(Apply apply);
    public int findDorm(String user_name);
    public List<Apply> getAll();
    public int updateApply(Apply apply);
    public Apply findApply(Integer apply_id);


}
