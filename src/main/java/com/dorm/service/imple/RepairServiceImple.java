package com.dorm.service.imple;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Repair;
import com.dorm.mapper.RepairMapper;
import com.dorm.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("repairService")
public class RepairServiceImple implements RepairService {

    @Autowired
    private RepairMapper repairMapper;
    @Override
    public PageInfo<Repair> findPageInfo(Integer dorm_id, Integer pageIndex, Integer pageSize) {
        PageInfo<Repair> pi = new PageInfo<Repair>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = repairMapper.totalCount(dorm_id);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Repair> dormRepairList =	repairMapper.getDormRepairList(dorm_id,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }
        return pi;
    }

    @Override
    public int addDormRepair(Repair repair) {
        return repairMapper.addDormRepair(repair);
    }

    @Override
    public int deleteDormRepair(Integer repair_id) {
        return repairMapper.deleteDormRepair(repair_id);
    }

    @Override
    public int updateDormRepair(Repair repair) {
        return repairMapper.updateDormRepair(repair);
    }

    @Override
    public Repair findDormRepairById(Integer repair_id) {
        return repairMapper.findDormRepairById(repair_id);
    }

    @Override
    public List<Repair> getAll() {
        List<Repair> dormRepairList = repairMapper.getAll();
        return dormRepairList;
    }

    @Override
    public List<Repair> findRepair(Integer dorm_id) {
        return repairMapper.findRepair(dorm_id);
    }

    @Override
    public List<Repair> getToRepair() {
        return repairMapper.getToRepair();
    }
}
