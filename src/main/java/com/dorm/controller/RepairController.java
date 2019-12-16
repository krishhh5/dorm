package com.dorm.controller;

import com.dorm.entity.PageInfo;
import com.dorm.entity.Repair;
import com.dorm.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RepairController {

    // 依赖注入
    @Autowired
    private RepairService repairService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormRepair")
    public String findDormRepair(Integer d_id,
                                 Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<Repair> di = repairService.findPageInfo(d_id,
                pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormrepair_list";
    }


    /**
     * 宿舍管理员添加维修信息
     */
    @RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody Repair dormrepair) {
        int d = repairService.addDormRepair(dormrepair);
        return "dormrepair_list";
    }

    /**
     * 宿舍管理员删除维修信息
     */
    @RequestMapping( "/deleteDormRepair")
    @ResponseBody
    public String deleteDormRepair(Integer r_id) {
        int d = repairService.deleteDormRepair(r_id);
        return "dormrepair_list";
    }

    /**
     * 宿舍管理员修改维修信息
     */
    @RequestMapping( "/updateDormRepair")
    public String updateRepair( Repair dormrepair) {
        int d = repairService.updateDormRepair(dormrepair);
        return "redirect:/findDormRepair";
    }


    //宿舍管理员编辑回填
    @RequestMapping( "/findDormRepairById")
    public String findDormRepairById(Integer repair_id, HttpSession session) {

        Repair d= repairService.findDormRepairById(repair_id);
        session.setAttribute("d",d);
        return "dormrepair_edit";
    }

    //学生填写维修申请
    @RequestMapping(value = "/applyRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String applyRepair(@RequestBody Repair dormrepair){
        int d = repairService.addDormRepair(dormrepair);
        return "r_dormrepair_list";
    }

    //学生打开'维修申请'
    @RequestMapping(value="/applyrepair")
    public String applyrepair(){
        return "r_dormrepair_list";
    }

    @RequestMapping(value="/findRepair")
    public String findRepair(Integer dorm_id,Model model){
        List<Repair> list = repairService.findRepair(dorm_id);
        model.addAttribute("list",list);
        return "r_dormrepair_list";
    }

    //维修人员打开'维修单'
    @RequestMapping(value="/repairForm")
    public String repairForm(Model m){
       List<Repair> repairs = repairService.getToRepair();
       m.addAttribute("repairs",repairs);
        return "repair_list";
    }

    //维修人员编辑回填
    @RequestMapping( "/findRepairById")
    public String findRepairById(Integer repair_id, HttpSession session) {

        Repair e= repairService.findDormRepairById(repair_id);
        session.setAttribute("e",e);
        return "repair_edit";
    }

    /**
     * 维修人员修改维修信息
     */
    @RequestMapping( "/updateRepair")
    public String updateDRepair(Repair dormrepair) {
        int d = repairService.updateDormRepair(dormrepair);

        return "redirect:/repairForm";
    }


//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//        //转换日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //CustomDateEditor为自定义日期编辑器
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//    }

}
