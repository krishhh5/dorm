package com.dorm.controller;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Visitor;
import com.dorm.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VisitorController {
    //依赖注入
    @Autowired
    private VisitorService visitorService;
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findVisitor")
    public String findVisitor(String visitor_name, Integer pageIndex,
                              Integer pageSize, Model model) {

        PageInfo<Visitor> pi = visitorService.findPageInfo(visitor_name,
                pageIndex,pageSize);
        model.addAttribute("pi",pi);
        model.addAttribute("visitor_name",visitor_name);
        return "visitor_list";
    }

    /**
     * 添加游客信息
     */

    @RequestMapping(value = "/addVisitor" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody Visitor visitor) {
        int v = visitorService.addVisitor(visitor);
        return "visitor_list";
    }


    //打开访客申请页面
    @RequestMapping(value = "/applyVisit")
    public String applyVisit() {
//        int v = visitorService.addVisitor(visitor);
        return "visit_list";
    }

    /**
     * 游客填写信息
     */

    @RequestMapping(value = "/addVisit" ,method = RequestMethod.POST)
    @ResponseBody
    public String addVisit(@RequestBody Visitor visitor) {
        int v = visitorService.addVisitor(visitor);
        return "visit_list";
    }

    //打开访客主页
    @RequestMapping(value="/homepage")
    public String toVisitor(){
        return "homepage";
    }

}
