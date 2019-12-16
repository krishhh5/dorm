package com.dorm.controller;

import com.dorm.entity.PageInfo;
import com.dorm.entity.User;
import com.dorm.mapper.UserMapper;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     */
    /**
     * 将提交数据(username,password)写入Admin对象
     */
    @RequestMapping(value = "/login")
    public String login(User user, Model model, HttpSession session, HttpServletRequest request) {


        String identity = (String)request.getParameter("identype");
        if (identity != null && !identity.equals("")) {
            if(identity.equals("student")) {
                user.setUser_right(1);
                User u = userMapper.findUser(user);
                if(u!=null){
                    session.setAttribute("u", u);
                    return "homepage1";
                }
            }
        }
        if (identity != null && !identity.equals("")) {
            if(identity.equals("admin")) {
                user.setUser_right(0);
                User u = userMapper.findUser(user);
                if(u!=null){
                    session.setAttribute("u", u);
                    return "homepage0";
                }
            }
        }
        if (identity != null && !identity.equals("")) {
            if(identity.equals("repair")) {
                user.setUser_right(2);
                User u = userMapper.findUser(user);
                if(u!=null){
                    session.setAttribute("u", u);
                    return "homepage2";
                }
            }
        }

//        if (identity != null && !identity.equals("")) {
//            if(identity.equals("visitor")) {
//                user.setUser_right(3);
//                User u = userMapper.findUser(user);
//                if(u!=null){
//                    session.setAttribute("u", u);
//                    return "homepage";
//                }
//            }
//        }

        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findStudent")
    public String findStudent(String user_name, Integer user_id,String student_class,
                              Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<User> pi = userService.findPageInfo(user_name,user_id,student_class,pageIndex,pageSize);
        model.addAttribute("pi",pi);
        model.addAttribute("user_name",user_name);
        return "student_list";
    }


    /**
     * 删除学生信息
     */
    @RequestMapping( "/deleteStudent")
    @ResponseBody
    public String deleteStudent(Integer user_id) {
        int s = userService.deleteStudent(user_id);
        return "student_list";
    }

    /**
     * 添加学生信息
     */

    @RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody User student) {
        int s = userService.addStudent(student);
        return "student_list";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST )
    public String updateStudent(User student) {
        int s = userService.updateStudent(student);
        return "redirect:/findStudent";
    }


    //通过id找到学生信息并进行回填
    @RequestMapping( "/findStudentById")
    public String findStudentById(Integer user_id,HttpSession session) {

        User s= userService.findStudentById(user_id);
        session.setAttribute("s",s);
        return "student_edit";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(User admin, Model model, HttpSession session) {
        session.invalidate();
        return "login";

    }

}
