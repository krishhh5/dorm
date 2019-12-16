package com.dorm.service;

import com.dorm.entity.PageInfo;
import com.dorm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 进行分页查询
     */

    //分页查询
    public PageInfo<User> findPageInfo(String userName, Integer userId, String studentClass,
                                       Integer pageIndex, Integer pageSize);

    //获取用户列表
    public List<User> getStudentList(@Param("userName") String userName, @Param("userId") Integer userId, @Param("name") String name, @Param("age") String age,
                                     @Param("studentAddress") Integer studentAddress,
                                     @Param("studentClass") String studentClass, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deleteStudent(Integer userId);   //删除学生信息
    public int addStudent(User student);   //添加学生信息
    public int updateStudent(User student); //修改学生信息
    public User findStudentById(Integer userId);
    public List<User> getAll();

    /**
     * 通过账号和密码查询管
     */
    public User findUser(User user);
}
