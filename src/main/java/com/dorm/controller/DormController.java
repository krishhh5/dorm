package com.dorm.controller;

import com.dorm.entity.Dorm;
import com.dorm.entity.PageInfo;
import com.dorm.entity.User;
import com.dorm.service.DormService;
import com.dorm.service.UserService;
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
public class DormController {
    @Autowired
    private DormService dormService;

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormitory")
    public String findDormitory(Integer dorm_num,
                                Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<Dorm> di = dormService.findPageInfo(dorm_num,
                pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormitory_list";
    }

    /**
     * 添加宿舍信息
     */
    @RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody Dorm dormitory) {
        int d = dormService.addDormitory(dormitory);
        return "dormitory_list";
    }

    /**
     * 删除宿舍信息
     */
    @RequestMapping( "/deleteDormitory")
    @ResponseBody
    public String deleteDormitory(Integer dorm_id) {
        int d = dormService.deleteDormitory(dorm_id);
        return "dormitory_list";
    }

    /**
     * 修改宿舍信息
     */
    @RequestMapping( "/updateDormitory")
    public String updateDormitory( Dorm dormitory) {
        int d = dormService.updateDormitory(dormitory);
        return "redirect:/findDormitory";
    }


    //回填
    @RequestMapping( "/findDormitoryById")
    public String findDormitoryById(Integer dorm_id, HttpSession session) {

        Dorm d= dormService.findDormitoryById(dorm_id);
        session.setAttribute("d",d);
        return "dormitory_edit";
    }

    /**
     * 宿舍人员信息查询
     */
    @RequestMapping(value = "/findDormitoryStudent")
    public String findDormitoryStudent(Dorm dormitory, Model model) {
        List<Dorm> d = dormService.findDormitoryStudent(dormitory);
        model.addAttribute("ds",d);
        return "dormitory_Studentlist";
    }

    //查询空宿舍
    @RequestMapping(value="/findEmptyDormitory")
    public String getEmptyDorm(Model model){
        List<Dorm> list = dormService.getEmptyDorm();
        model.addAttribute("list",list);
        return "dormitory_nlist";
    }

    //分配宿舍
    @RequestMapping(value="/arrangeDorm",method = RequestMethod.POST)
    public String arrangeDorm(@RequestBody User student) {
        int s = userService.addStudent(student);
        int bed_num = dormService.findBedNum(student.getDorm_id());
        int i=dormService.arrangeDorm(student.getDorm_id(),bed_num+1);
        return "dormitory_nlist";
    }


}
