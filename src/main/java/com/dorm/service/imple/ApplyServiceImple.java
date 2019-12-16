package com.dorm.service.imple;

import com.dorm.entity.Apply;
import com.dorm.mapper.ApplyMapper;
import com.dorm.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("applyService")
public class ApplyServiceImple implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public int addApply(Apply apply) {
        return applyMapper.addApply(apply);
    }

    @Override
    public int findDorm(String user_name) {
        return applyMapper.findDorm(user_name);
    }

    @Override
    public List<Apply> getAll() {
        return applyMapper.getAll();
    }

    @Override
    public int update(Apply apply) {
        return applyMapper.updateApply(apply);
    }

    @Override
    public Apply findApply(Integer id) {
        return applyMapper.findApply(id);
    }
}
