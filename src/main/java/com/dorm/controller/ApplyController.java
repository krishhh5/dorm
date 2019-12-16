package com.dorm.controller;

import com.dorm.entity.Apply;
import com.dorm.entity.Dorm;
import com.dorm.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    //填写宿舍申请表
    @RequestMapping(value="/applyDorm", method = RequestMethod.POST)
    @ResponseBody
    public String applyDorm(@RequestBody Apply apply){
        int i = applyService.addApply(apply);
        return "s_dormitory_list";
    }

    //学生打开宿舍申请列表
    @RequestMapping(value="/applydorm")
    public String applydorm(){
        return "s_dormitory_list";
    }

    //学生通过名字找到宿舍
    @RequestMapping(value="/findDorm")
    public String findDorm(String user_name,Model model){
        int dorm_id = applyService.findDorm(user_name);
        model.addAttribute("dorm_id",dorm_id);
        model.addAttribute("user_name",user_name);
        return "s_dormitory_list";
    }

    //管理员查看申请表
    @RequestMapping("/apply")
    public String getAll(Model model){
        List<Apply> list = applyService.getAll();
        model.addAttribute("list",list);
        return "apply_list";
    }


    /**
     * 修改宿舍信息
     */
    @RequestMapping( "/update")
    public String updateApply(Apply apply) {
        int d = applyService.update(apply);
        return "redirect:/apply";
    }

    //回填
    @RequestMapping( "/findApply")
    public String findDormitoryById(Integer apply_id, HttpSession session) {

        Apply apply = applyService.findApply(apply_id);
        session.setAttribute("a",apply);
        return "apply_edit";
    }

}
