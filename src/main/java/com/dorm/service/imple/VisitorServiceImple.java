package com.dorm.service.imple;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Visitor;
import com.dorm.mapper.VisitorMapper;
import com.dorm.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("visitorService")
public class VisitorServiceImple implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    @Override
    public PageInfo<Visitor> findPageInfo(String visitor_name, Integer pageIndex, Integer pageSize) {
        PageInfo<Visitor> pi = new PageInfo<Visitor>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = visitorMapper.totalCount(visitor_name);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList =	visitorMapper.getVisitorList(visitor_name,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(visitorList);
        }
        return pi;
    }

    @Override
    public int addVisitor(Visitor visitor) {
        return visitorMapper.addVisitor(visitor);
    }

    @Override
    public List<Visitor> getAll() {
        List<Visitor> visitorList = visitorMapper.getAll();
        return visitorList;
    }
}
