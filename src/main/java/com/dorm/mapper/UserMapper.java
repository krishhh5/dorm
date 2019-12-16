package com.dorm.mapper;

import com.dorm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("user_name") String user_name, @Param("user_id") Integer user_id,
                              @Param("student_class") String student_class);
    //获取用户列表
    public List<User> getStudentList(@Param("user_name") String user_name, @Param("user_id") Integer user_id,@Param("student_class") String student_class,
                                     @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

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
