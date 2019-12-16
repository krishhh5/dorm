package com.dorm.service.imple;

import com.dorm.entity.Dorm;
import com.dorm.entity.PageInfo;
import com.dorm.mapper.DormMapper;
import com.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dormService")
public class DormServiceImple implements DormService {
    @Autowired
    private DormMapper dormMapper;

    @Override
    public PageInfo<Dorm> findPageInfo(Integer dorm_num, Integer pageIndex, Integer pageSize) {
        PageInfo<Dorm> pi = new PageInfo<Dorm>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormMapper.totalCount(dorm_num);
        if (totalCount > 0) {
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Dorm> dormitoryList = dormMapper.getDormitoryList(dorm_num,
                    (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
            pi.setList(dormitoryList);
        }
        return pi;
    }

    @Override
    public int addDormitory(Dorm dormitory) {
        return dormMapper.addDormitory(dormitory);
    }

    @Override
    public int deleteDormitory(Integer dorm_id) {
        return dormMapper.deleteDormitory(dorm_id);
    }

    @Override
    public int updateDormitory(Dorm dormitory) {
        return dormMapper.updateDormitory(dormitory);
    }

    @Override
    public Dorm findDormitoryById(Integer d_id) {
        Dorm d = dormMapper.findDormitoryById(d_id);
        return d;
    }

    //查询宿舍人员信息
    @Override
    public List<Dorm> findDormitoryStudent(Dorm dormitory) {
        List<Dorm> d = dormMapper.findDormitoryStudent(dormitory);
        return d;
    }

    @Override
    public List<Dorm> getAll() {
        List<Dorm> dormitoryList = dormMapper.getAll();
        return dormitoryList;
    }

    @Override
    public List<Dorm> getEmptyDorm() {
        return dormMapper.getEmptyDorm();
    }

    @Override
    public int arrangeDorm(Integer dorm_num,Integer bed_num) {
        return dormMapper.arrangeDorm(dorm_num,bed_num);
    }

    @Override
    public int findBedNum(Integer dorm_num) {
        return dormMapper.findBedNum(dorm_num);
    }
}
